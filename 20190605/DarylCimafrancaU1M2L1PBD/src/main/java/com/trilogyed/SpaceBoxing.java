package com.trilogyed;

import java.util.Scanner;

public class SpaceBoxing {

    public static String getWeight(int weight, float planet) {
        float planetWeight = weight*planet;

        String result = "\nYou weigh " + planetWeight + " pounds on this planet.";
        return result;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //declare user weight
        int userWeight;
        int userSelection;

        //relative gravity values;
        float venusG = 0.78f;
        float marsG = 0.39f;
        float jupiterG = 2.65f;
        float saturnG = 1.17f;
        float uranusG= 1.05f;
        float neptuneG= 1.23f;

        System.out.println("Please enter your current weight in pounds: ");
        userWeight = Integer.parseInt(myScanner.nextLine());


        System.out.println("\nI have information on the following planets: ");
        System.out.print(
                "1.) Venus     2.) Mars    3.) Jupiter" +
                "\n4.) Saturn    5.) Uranus  6.) Neptune\n");

        System.out.println("\nWhich planet are you visiting?");
        userSelection = Integer.parseInt(myScanner.nextLine());

        switch (userSelection){
            case 1:
                System.out.println(getWeight(userWeight, venusG));
                break;
            case 2:
                System.out.println(getWeight(userWeight, marsG));
                break;
            case 3:
                System.out.println(getWeight(userWeight, jupiterG));
                break;
            case 4:
                System.out.println(getWeight(userWeight, saturnG));
                break;
            case 5:
                System.out.println(getWeight(userWeight, uranusG));
                break;
            case 6:
                System.out.println(getWeight(userWeight, neptuneG));
                break;
                default:
                    System.out.println("You didn't put in a planet within the scope!");


        }
    }
}
