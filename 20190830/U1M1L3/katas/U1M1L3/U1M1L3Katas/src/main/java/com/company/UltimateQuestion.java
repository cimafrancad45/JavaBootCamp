package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String userInput;
        int userNum;

        System.out.println("I'm thinking of a number of between 1 and 100, what is it???");

        do {

            userInput = myScanner.nextLine();
            userNum = Integer.parseInt(userInput);
        } while (userNum != 42);

        System.out.println("That's the number I was looking for! 42 is definitely the answer!");
    }
}
