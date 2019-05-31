package com.trilogyed;

import java.util.Random;


public class HowManyTimesTo7 {
    public static void main(String[] args) {
        Random random = new Random();

        int sevenSevens = 0;
        int sevenCounter = 0;
        int rollAmount = 0;


        for (int i = 0; i <= 100; i++) {
            //the bound for the random includes a 0 hence the +1
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            int totalRoll = dice1 + dice2;

            if (totalRoll == 7) {
                System.out.println("I rolled a 7!");
                sevenCounter = sevenCounter + 1;
            }
            if (sevenCounter <= 7) {
                sevenSevens = sevenSevens + 1;
                rollAmount = i;
            }
        }
        if (sevenSevens < 7) {
            System.out.println("Seven rolls of seven was not made... Seven was rolled" + sevenCounter + " times.");
        } else {
            System.out.println("It took " + rollAmount + " rolls to get a seven seven times.");
            System.out.println("Out of 100 times, seven was rolled " + sevenCounter + " times");

        }
    }
}