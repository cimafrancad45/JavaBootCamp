package com.DarylC;

import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int food1 = 3;
        int food2 = 3;
        int food3 = 3;
        String userPick;
        int userNum;

        System.out.println("You're very hungry and you're at a Costco. Choose food samples and choose how many samples you want to take.");


        while (food1 > 0 || food2 > 0 || food3 > 0) {
            System.out.println("Current food samples available.");
            System.out.println("A: " + food1);
            System.out.println("B: " + food2);
            System.out.println("C: " + food3);
            System.out.println("\nPick a food sample");
            userPick = myScanner.nextLine();
            userPick = userPick.substring(0, 1).toUpperCase() + userPick.substring(1);

            switch (userPick){
                case "A":
                    System.out.println("\nSelect how many to to take:");
                    userNum = Integer.parseInt(myScanner.nextLine());
                    food1 = food1 - userNum;
                    break;
                case "B":
                    System.out.println("\nSelect how many to to take:");
                    userNum = Integer.parseInt(myScanner.nextLine());
                    food2 = food2 - userNum;
                    break;
                case "C":
                    System.out.println("\nSelect how many to to take:");
                    userNum = Integer.parseInt(myScanner.nextLine());
                    food3 = food3 - userNum;
                    break;
                    default:
                        System.out.println("That isn't a valid entry, try again.");
            }

        }

        System.out.println("\nCongrats, you are now full from eating all the samples!");
    }
}
