package com.trilogyed;

import java.util.ArrayList;
import java.util.Random;

public class BasicArrayList2 {
    public static void main(String[] args) {

        ArrayList<Integer> newList = new ArrayList<>();

        Random random = new Random();



        for (int i = 0 ; i <10; i++){
            newList.add(random.nextInt(100)+1);
            System.out.println("Slot " + i + " contains a: " + newList.get(i));
        }

        System.out.println("ArrayList newList: " + newList);

    }
}
