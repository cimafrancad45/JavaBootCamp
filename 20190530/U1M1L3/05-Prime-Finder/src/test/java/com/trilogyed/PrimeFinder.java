package com.trilogyed;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);


        System.out.println("Put in a number and I will list all the prime numbers leading up to that number: ");
        int userNum = Integer.parseInt(myScanner.nextLine());
        int x;
        int primeCheck = x%2;

        //0 and 1 are not prime numbers, but 2 is a prime Number. This ensures that 2 will always be printed out but not 1 or 0

        System.out.println("Prime numbers leading up to " + userNum);
        if (userNum > 1){
        System.out.println(2);
        }

        for (int i = 2 ; i <= userNum ; i++) {
            primeCalc = userNum%i;
            if (primeCheck == 0){
                System.out.println(i);
            }
        }
    }
}
