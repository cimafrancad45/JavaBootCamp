package com.trilogyed;

import java.util.ArrayList;
import java.util.Random;

public class CopyingArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> newList = new ArrayList<>();
        ArrayList<Integer> copiedList = new ArrayList<>();

        Random random = new Random();



        for (int i = 0 ; i <10; i++){
            newList.add(random.nextInt(100)+1);
            Integer temp= newList.get(i);
            copiedList.add(temp);
        }

        newList.set(9, -7);
        System.out.println("ArrayList newList: " + newList);
        System.out.println("ArrayList copiedList: " + copiedList);

    }
}
