package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random random = new Random();


        System.out.println("Welcome to Hi-Low!");
        System.out.println("Please enter your name: ");

        String userName = myScanner.nextLine();

        System.out.println("OK, " + userName + ", here are the rules:");
        System.out.println("I will come up with a number between 1 and 100 and you will have to guess which number I have picked.");
        System.out.println("Are you ready? Let's go!");
        int comNum = random.nextInt(100) + 1;
        int userNum;
        int userGuess = 0;


        do {

            System.out.println("Guess a number!");
//            System.out.println(comNum);
            userNum = Integer.parseInt(myScanner.nextLine());
            if (userNum > comNum) {
                userGuess = userGuess + 1;
                System.out.println("Too High!");
            } else if (userNum < comNum) {
                userGuess = userGuess + 1;
                System.out.println("Too Low!");
            }

        } while (comNum != userNum);

        System.out.println("Congratulations, " + userName + "! You win!");
        System.out.println("It took you " + userGuess + " guesses to find my number!");


    }
}
