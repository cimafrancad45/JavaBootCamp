package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int num1;
        int num2;
        int num3;
        int num4;
        int num5;

        System.out.println("Welcome to add 5!");
        System.out.println("Enter your first number:" );
        num1 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Enter your second number:");
        num2 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Enter your third number:");
        num3 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Enter your fourth number:");

        num4 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Enter your last number:");
        num5 = Integer.parseInt(myScanner.nextLine());

        int sum = num1+ num2 + num3 + num4 + num5;

        System.out.println("The combined total of your numbers is: " + sum);
    }
}
