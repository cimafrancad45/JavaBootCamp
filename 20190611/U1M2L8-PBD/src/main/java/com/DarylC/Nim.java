package com.DarylC;

import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        String[] players = new String[2];


        int shekle1 = 5;
        int shekle2 = 5;
        int shekle3 = 5;

        String userPick;
        int userNum;

        int turn = 0;
        int playerPrompt;


        System.out.println("Enter player 1's name: ");
        players[1] = myScanner.nextLine();

        System.out.println("Enter player 2's name: ");
        players[0] = myScanner.nextLine();

        System.out.println("You're both trying to grab the shekles, but whoever gets the last one gets sent to the shadow realm!");


        while (shekle1 > 0 || shekle2 > 0 || shekle2 > 0) {
            turn = turn + 1;
            playerPrompt = turn % 2;

            System.out.println("\n" + players[playerPrompt] + ", COLLECT YOUR SHEKLES.");
            System.out.println("A: " + shekle1);
            System.out.println("B: " + shekle2);
            System.out.println("C: " + shekle3);
            System.out.println("\nPick from a group of shekles!");
            userPick = myScanner.nextLine();
            userPick = userPick.substring(0, 1).toUpperCase() + userPick.substring(1);

            switch (userPick) {
                case "A":
                    System.out.println("\nSelect how many to take:");
                    userNum = Integer.parseInt(myScanner.nextLine());
                    shekle1 = shekle1 - userNum;
                    break;
                case "B":
                    System.out.println("\nSelect how many to take:");
                    userNum = Integer.parseInt(myScanner.nextLine());
                    shekle2 = shekle2 - userNum;
                    break;
                case "C":
                    System.out.println("\nSelect how many to take:");
                    userNum = Integer.parseInt(myScanner.nextLine());
                    shekle3 = shekle3 - userNum;
                    break;
                default:
                    System.out.println("\nInvalid character! Try again!");
                    turn = turn - 1;
                    break;
            }
            if (shekle1 <= 0 && shekle2 <= 0 && shekle3 <= 0) {
                if (playerPrompt == 1) {
                    System.out.println("\n" + players[1] + ", you lose!");
                } else {
                    System.out.println("\n" + players[0] + ", you lose!");
                }
            }
        }


    }

}


