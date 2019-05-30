package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int num;
        System.out.println("We're gonna take your number and add 13 to it for no raisin. Put in a number:");
        num = Integer.parseInt(myScanner.nextLine());

        int add13 = num + 13;

        System.out.println(add13);

    }
}
