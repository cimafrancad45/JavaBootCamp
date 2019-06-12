package com.company;


import java.util.ArrayList;
import java.util.List;

public class ReverseAndPrint {

    public static void main(String[] args) {

        int [] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

        System.out.println("--------------");
        System.out.println("Normal");
        System.out.println("--------------");

        for(int element : numbers) {
            System.out.println(element);
        }

        int[] reversed = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[numbers.length-(i+1)];
        }

        System.out.println("--------------");
        System.out.println("Reversed");
        System.out.println("--------------");

        for(int element : reversed) {
            System.out.println(element);
        }

        //REFACTORED CODE

        List<Integer> newNumbers = new ArrayList<Integer>();

        //taking the numbers array and converting it into a new List.
        for (int values : numbers){
            newNumbers.add(values);
        }

        System.out.println("--------------");
        System.out.println("Normal Refactored");
        System.out.println("--------------");
        //using an enhanced for loop, we print out the values in the new List
        for (Integer values: newNumbers){
            System.out.println(values);
        }

        //creating a new list to push in reversed values.
        List<Integer> newReversed = new ArrayList<Integer>();

        //using the above logic, we push the newNumber list into the newReversed list
        for(int i = 0 ; i < newNumbers.size() ; i++) {
            newReversed.add(newNumbers.get((newNumbers.size()-(i+1))));
        }

        System.out.println("--------------");
        System.out.println("Reversed Refactored");
        System.out.println("--------------");

        for(Integer values : newReversed){
            System.out.println(values);
        }


        }

}
