package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = keyboard.nextInt();
        System.out.print("Annual Interest Rate: ");
        float annualRate = keyboard.nextFloat();
        System.out.print("Period (Years): ");
        byte periodYears = keyboard.nextByte();

        Loan loan = new Loan();
        loan.setPrincipal(principal);
        loan.setPeriod(periodYears);
        loan.setAnnualRate(annualRate);

        System.out.println(NumberFormat.getCurrencyInstance().format(loan.calculateMortgage()));
        printPaymentSchedule(loan);
    }



//    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
//        System.out.println();
//        System.out.println("PAYMENT SCHEDULE");
//        System.out.println("----------------");
//        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
//            double balance = calculateBalance(principal, annualInterest, years, month);
//            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
//        }
//    }

    private static void printPaymentSchedule(Loan loan) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= loan.getPeriod() * MONTHS_IN_YEAR; month++) {
            double balance = loan.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

}

