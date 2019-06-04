package com.company;

import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Input a number and we'll count to it");
        int userNum = Integer.parseInt(myScanner.nextLine());

        for (int i = 0; i <= userNum; i++) {
            System.out.println(i);
        }
    }
}
