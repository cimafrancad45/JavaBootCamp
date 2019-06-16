package com.trilogyed;

public class App {
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        //integers

        System.out.println("Add integers: " + calc.add(1,1));

        System.out.println("Subtract integers: " + calc.subtract(23,52));

        System.out.println("Multiply integers: " + calc.multiply(2,3));

        System.out.println("Divide integers: " + calc.divide(12,3));

        System.out.println("Divide Integers: " + calc.divide(12,7));

        //doubles

        System.out.println("Add doubles: " + calc.add(3.4,2.3));

        System.out.println("Multiply doubles: " + calc.multiply(6.7,4.4));

        System.out.println("Subtract doubles: " + calc.subtract(5.5,0.5));

        System.out.println("Divide doubles:" + calc.divide(10.8,2.2));
    }
}
