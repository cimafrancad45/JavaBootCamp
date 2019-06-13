package com.trilogyed;

import java.util.ArrayList;
import java.util.Random;

public class BasicArrayList3 {
    public static void main(String[] args) {
        {

            ArrayList<Integer> newList = new ArrayList<>();

            Random random = new Random();


            for (int i = 0; i < 1000; i++) {
                newList.add(random.nextInt(89) + 10);
                System.out.println("Slot " + (i + 1) + ": " + newList.get(i));
            }


        }
    }
}
