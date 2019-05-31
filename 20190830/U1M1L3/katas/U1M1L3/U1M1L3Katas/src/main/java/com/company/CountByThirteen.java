package com.company;

import java.util.Scanner;

public class CountByThirteen {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Input a number and we'll count to it in 13s");
        int userNum = Integer.parseInt(myScanner.nextLine());

        for (int i = 0; i <= userNum; i = i + 13) {
            System.out.println(i);
        }
    }
}