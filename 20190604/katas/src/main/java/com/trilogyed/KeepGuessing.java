package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class KeepGuessing {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner myScanner = new Scanner(System.in);


        int randomNum = random.nextInt(10) + 1;
        int userGuess;
        System.out.println("Try to guess a number 1-10.");


        do {
            userGuess = Integer.parseInt(myScanner.nextLine());
            if (userGuess != randomNum) {
                System.out.println("Wrong! guess again");
            } else if (userGuess == randomNum) {
                System.out.println("Congratulations, you guessed the right number!");
            }
        } while (userGuess != randomNum);
    }
}
