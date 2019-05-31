package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int num;

        System.out.println("Put a number then I'll double the pleasure, double the fun plus five.");
        num = Integer.parseInt(myScanner.nextLine());

        int doublePlusFive = (num * 2) + 5;

        System.out.println(doublePlusFive);

    }
}
