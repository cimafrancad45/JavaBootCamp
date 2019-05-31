package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Input a number and I'll determine if it's odd or even.");
        int userNum = Integer.parseInt(myScanner.nextLine());

        if (userNum%2 == 0 ){
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
