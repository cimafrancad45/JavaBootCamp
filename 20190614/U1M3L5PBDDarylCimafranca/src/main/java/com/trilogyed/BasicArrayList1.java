package com.trilogyed;

import java.util.ArrayList;

public class BasicArrayList1 {
    public static void main(String[] args) {
        ArrayList<Integer> newList = new ArrayList<>();

//doing newList.size() returns a 0, so setting a 10 for now
        for(int i = 0 ; i < 10 ; i++){
            newList.add(-133);
            System.out.println("Slot " + i +" contains a: " +newList.get(i));
        }

    }

}
