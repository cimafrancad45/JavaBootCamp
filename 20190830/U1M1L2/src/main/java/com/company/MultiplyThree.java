package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int num1;
        int num2;
        int num3;

        System.out.println("Number 1: ");
        num1 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Number 2: ");
        num2 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Number 3: ");
        num3 = Integer.parseInt(myScanner.nextLine());

        int tripleNum = num1 * num2 * num3;


        System.out.println(tripleNum);



    }
}