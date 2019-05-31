package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        int userNum;

        do {
            System.out.println("Give me a number between 15 and 32");

            userInput = myScanner.nextLine();
            userNum = Integer.parseInt(userInput);

        } while(userNum < 16 || userNum > 31);



    }
}
