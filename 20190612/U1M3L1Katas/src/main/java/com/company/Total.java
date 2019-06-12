package com.company;

import java.util.ArrayList;
import java.util.List;

public class Total {

    public static void main(String[] args) {

        int [] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

        int total = 0;

        for(int element : numbers) {
          total += element;
        }

        System.out.println("The sum of all elements in the array is " + total);

        System.out.println("\n--------------------------------- Refactored Code -----------------------------------\n");
        //REFACTORED CODE
        //declare a new list
        List<Integer> newNumbers = new ArrayList<Integer>();

        for (int values : numbers){
            newNumbers.add(values);
        }

        int newTotal = 0;

        for (int values : newNumbers){
            newTotal += values;
        }

        System.out.println("The sum of all elements in the array is " + newTotal);
    }

}
