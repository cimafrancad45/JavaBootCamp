package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        //decimal formatting
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);

        System.out.println("Input three numbers and get the average.");
        System.out.println("Number 1: ");
        float num1 = Float.parseFloat(myScanner.nextLine());

        System.out.println("Number 2: ");
        float num2 = Float.parseFloat(myScanner.nextLine());

        System.out.println("Number 3: ");
        float num3 = Float.parseFloat(myScanner.nextLine());

        float avg = (num1 + num2 + num3)/3f;

        String avgAsString = df.format(avg);
        System.out.println(avgAsString);

    }
}
