package com.trilogyed;



import com.trilogyed.interfaces.Converter;

import java.util.Scanner;

public class ConverterApplication {

    public static void main(String[] args) {


        Scanner myScanner = new Scanner(System.in);
        int userNumber;
        ConverterSwitch switchConverter = new ConverterSwitch();
        ConverterIf ifConverter = new ConverterIf();

        System.out.println("Enter a number: ");
        userNumber = Integer.parseInt(myScanner.nextLine());
        System.out.println("\n------ Using a Switch statement -------");
        System.out.println(switchConverter.convertMonth(userNumber));
        System.out.println(switchConverter.convertDay(userNumber));

        System.out.println("\n------ Using if statements ------------");
        System.out.println(ifConverter.convertMonth(userNumber));
        System.out.println(ifConverter.convertDay(userNumber));





    }
}
