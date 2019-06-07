package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {

    Scanner myScanner = new Scanner(System.in);


    public int readInt(String prompt){
        System.out.println(prompt);
        int userInt;
        userInt = Integer.parseInt(myScanner.nextLine());
        return userInt;
    }

    public long readLong(String prompt){
        System.out.println(prompt);
        long userLong;
        userLong = Long.parseLong(myScanner.nextLine());
        return userLong;
    }

    public double readDouble(String prompt){
        System.out.println(prompt);
        double userDouble;
        userDouble = Double.parseDouble(myScanner.nextLine());
        return userDouble;
    }

    public float readFloat(String prompt){
        System.out.println(prompt);
        float userFloat;
        userFloat = Float.parseFloat(myScanner.nextLine());
        return userFloat;
    }

    public String readString(String prompt){
        System.out.println(prompt);
        String userString;
        userString = myScanner.nextLine();
        return userString;
    }
}
