package com.company;

public class Loan {
    private int principal;
    private float annualRate;
    private byte period;

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;


    public double calculateMortgage() {

        float monthlyInterest = this.annualRate / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (this.period * MONTHS_IN_YEAR);

        double mortgage = this.principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public double calculateBalance(int paymentsMade) {

        float monthlyInterest = this.annualRate / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (this.period * MONTHS_IN_YEAR);

        double balance = this.principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, paymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public void setAnnualRate(float annualRate) {
        if (annualRate <= 0)
            throw new IllegalArgumentException("Nothing is free, chum.");
        this.annualRate = annualRate;
    }

    public void setPrincipal(int principal) {
        if (principal < 1_000 || principal > 1_000_000)
            throw new IllegalArgumentException("Please ask for a more reasonable loan.");
        this.principal = principal;
    }

    public void setPeriod(byte period) {
        if (period < 1 || period > 30)
            throw new IllegalArgumentException("Loan period must be between 1 and 30.");
        this.period = period;
    }

    public int getPrincipal() {
        return principal;
    }

    public int getPeriod(){
        return period;
    }
}
