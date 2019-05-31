package com.company;

import java.util.Scanner;

public class CountByTwo {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Input a number and we'll count to it in 2s");
        int userNum = Integer.parseInt(myScanner.nextLine());

        for (int i = 0; i <= userNum; i = i + 2) {
            System.out.println(i);
        }
    }
}
