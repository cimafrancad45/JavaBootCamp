package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte47 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random random = new Random();
        int userGuess;
        int aceNum = random.nextInt(3)+1;

        System.out.println("Which one is the Ace?");

        System.out.println("***   ***   ***");
        System.out.println("***   ***   ***");
        System.out.println(" 1     2     3 ");

        System.out.println("\nWhich card do you pick?");
        userGuess = Integer.parseInt(myScanner.nextLine());

        switch (aceNum){
            case 1:
                System.out.println("AAA   ***   ***");
                System.out.println("AAA   ***   ***");
                System.out.println(" 1     2     3 ");
                break;
            case 2:
                System.out.println("***   AAA   ***");
                System.out.println("***   AAA   ***");
                System.out.println(" 1     2     3 ");
                break;
            case 3:
                System.out.println("***   ***   AAA");
                System.out.println("***   ***   AAA");
                System.out.println(" 1     2     3 ");
                break;
            default:
                System.out.println("Oops, I dropped my cards.");
        }
        if (userGuess == aceNum) {
            System.out.println("You got it! Nice job!");
        } else {
            System.out.println("Wrong card!");
        }


    }
}