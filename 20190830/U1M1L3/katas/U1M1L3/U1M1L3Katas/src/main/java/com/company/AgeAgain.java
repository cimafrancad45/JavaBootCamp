package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String userGrade;
        String collegeAnswer;
        String userCollege;
        String userPlan;
        String userJob;

        System.out.println("Hello! How old are you?");
        int userAge = Integer.parseInt(myScanner.nextLine());

        if (userAge < 14) {
            System.out.println("How young! What grade are you in?");
            userGrade = myScanner.nextLine();
            System.out.println("Wow! " + userGrade + " grade - that sounds exciting!");

        }

        if (userAge >= 14 && userAge <= 18) {
            System.out.println("Are you planning to go to College?");
            collegeAnswer = myScanner.nextLine();
            if (collegeAnswer.equals("yes")) {
                System.out.println("Which college?");
                userCollege = myScanner.nextLine();
                System.out.println(userCollege + " is a great school!");
            } else if (collegeAnswer.equals("no")) {
                System.out.println("What do you want to do after High School?");
                userPlan = myScanner.nextLine();
                System.out.println("Wow, " + userPlan + " sounds like a plan!");

            }
        }

        if (userAge > 18) {
            System.out.println("What's your job?");
            userJob = myScanner.nextLine();
            System.out.println(userJob + " sounds like a great job!");
        }
    }
}
