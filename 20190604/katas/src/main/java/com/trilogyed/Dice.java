package com.trilogyed;

import java.util.Random;

public class Dice {


    public static void main(String[] args) {

        Random random = new Random();

        System.out.println("Time to r-r-r-r-r-roll the dice!");
        int rollValue1 = random.nextInt(6) + 1;
        int rollValue2 = random.nextInt(6) + 1;
        int totalRoll = rollValue1 + rollValue2;
        System.out.println("\nRoll 1: " + rollValue1);
        System.out.println("Roll 2: " + rollValue2);

        System.out.println("\nTotal roll: " + totalRoll);


    }
}
