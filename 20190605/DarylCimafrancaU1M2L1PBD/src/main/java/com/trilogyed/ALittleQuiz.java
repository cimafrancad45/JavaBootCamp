package com.trilogyed;

import java.util.Scanner;

public class ALittleQuiz {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String userReady;
        int userAnswer;
        int userScore = 0;

        System.out.println("Welcome to my little quiz, are you ready? y/n");
        userReady = myScanner.nextLine();

        switch (userReady) {
            case "n":
                System.out.println("Okay, maybe next time.");
                break;
            case "y":
                System.out.println("Let's begin! \n");
                System.out.println(
                        "In Street Fighter II, what is Ryu's signature special move?" +
                        "\n 1.) Sonic Boom" +
                        "\n 2,) Psycho Crusher" +
                        "\n 3.) Hadoken" +
                        "\n 4.) Yoga Fire");

                userAnswer = Integer.parseInt(myScanner.nextLine());

                if (userAnswer == 3) {
                    userScore = userScore + 1;
                    System.out.println("\n That is correct! ");
                } else {
                    System.out.println("\n Bzztt! Wrong!");
                }

                System.out.println(
                        "Which was the first Final Fantasy to introduce the job system?" +
                                "\n 1.) Final Fantasy II" +
                                "\n 2,) Final Fantasy III" +
                                "\n 3.) Final Fantasy IV" +
                                "\n 4.) Final Fantasy I");

                userAnswer = Integer.parseInt(myScanner.nextLine());

                if (userAnswer == 4) {
                    userScore = userScore + 1;
                    System.out.println("\n That is correct! ");
                } else {
                    System.out.println("\n Bzztt! Wrong!");
                }

                System.out.println(
                        "What is the name of Mario's dinosaur friend introduced in Super Mario World?" +
                                "\n 1.) Yoshi" +
                                "\n 2,) Luigi" +
                                "\n 3.) Toad" +
                                "\n 4.) Donkey Kong");

                userAnswer = Integer.parseInt(myScanner.nextLine());

                if (userAnswer == 1) {
                    userScore = userScore + 1;
                    System.out.println("\n That is correct! ");
                } else {
                    System.out.println("\n Bzztt! Wrong!");
                }

                System.out.println(
                        "\n You've gotten " + userScore + " out of 3 correct!" +
                        "\n Thank you for playing!");
                break;
            default:
                System.out.println("That doesn't tell me if you're ready! It's either y or n for yes or no!");

        }

    }

}