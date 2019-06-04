package com.company;

public class App {

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int subtractOrZero(int a, int b) {
        int value = a - b;

        if (value < 0) {
            return 0;
        } else {
            return value;
        }
    }

    public static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    public static int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }

    public static int isLarger(int first, int second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }

    public static void main(String[] args) {
        System.out.println(subtract(5,4));
        System.out.println(subtractOrZero(6,9));
        System.out.println(subtractOrZero(9, 6));
        System.out.println(max(3,9,6));
        System.out.println(min(3,5,6));
        System.out.println(isLarger(10,11));
        System.out.println(isLarger(15,10));
    }

}

