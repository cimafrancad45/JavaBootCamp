package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class OneShotHiLo {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random random = new Random();
        int userGuess;
        int randomNum = random.nextInt(100) +1;

        System.out.println("Wanna play an unfair game? Guess the number I'm thinking of.");
        userGuess = Integer.parseInt(myScanner.nextLine());

        if (userGuess == randomNum) {
            System.out.println("Wow, you actually got it right! Impressive!");
        } else {
            System.out.println("Hah! You lose!");
        }
    }
}
