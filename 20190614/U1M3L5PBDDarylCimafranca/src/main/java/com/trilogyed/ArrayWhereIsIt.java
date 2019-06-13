package com.trilogyed;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayWhereIsIt {
    public static void main(String[] args) {

        ArrayList<Integer> newList = new ArrayList<>();
        Scanner myScanner = new Scanner(System.in);
        Random random = new Random();

        int userIn;

        for (
                int i = 0;
                i < 10; i++) {
            newList.add(random.nextInt(100) + 1);
        }

        System.out.println("ArrayList newList: " + newList);
        System.out.println("Find a number within the array: ");
        userIn = Integer.parseInt(myScanner.nextLine());

        if (newList.contains(userIn)) {
            for (int i = 0; i < newList.size(); i++) {
                if (newList.get(i) == userIn) {
                    System.out.println(userIn + " is in slot " + i);
                }
            }
        } else {
            System.out.println("I'm sorry, that number is not in the array");
        }


    }


}
