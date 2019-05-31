package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Input your age and see what you can do.");
        int userAge = Integer.parseInt(myScanner.nextLine());

        if (userAge >= 100) {
            System.out.println("You are more than a century old.");
        }
        if (userAge >= 80 && userAge <= 89) {
            System.out.println("You are an octogenerian.");
        }
        if(userAge >= 65){
            System.out.println("You can retire.");
        }
        if(userAge >= 55) {
            System.out.println("You are eligible for AARP.");
        }
        if(userAge >= 35){
            System.out.println("You can become president.");
        }
        if(userAge >=21){
            System.out.println("You can drink alcohol.");
        }
        if(userAge >=18){
            System.out.println("You can vote.");
        }

    }
}
