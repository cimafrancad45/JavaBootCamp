package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int x;
        int y;

        System.out.println("Number 1: ");
        x = Integer.parseInt(myScanner.nextLine());

        System.out.println("Number 2: ");
        y = Integer.parseInt(myScanner.nextLine());

        int subtract = x - y;
        System.out.println(subtract);
    }
}
