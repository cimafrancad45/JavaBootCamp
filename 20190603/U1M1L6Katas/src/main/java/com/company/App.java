package com.company;

public class App {
    public static int total(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;

    }

    public static int totalOdd(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int oddNum = i % 2;
            if (oddNum != 0) {
                sum += arr[i];
            }
        }

        return sum;

    }

    public static int totalEven(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int evenNum = i % 2;
            if (evenNum == 0) {
                sum += arr[i];
            }
        }

        return sum;

    }

    public static int secondLargestNumber(int[] arr) {

        // Declare initial values for the method.
        int[] sortArray = arr;
        int arrayNum;

        //Algorithm that sorts array inputted by user.

        for (int i = 1; i < sortArray.length; i++) {
            for (int q = i; q > 0; q--) {
                if (sortArray[q] < sortArray[q - 1]) {
                    arrayNum = sortArray[q];
                    sortArray[q] = sortArray[q - 1];
                    sortArray[q - 1] = arrayNum;
                }

            }
        }


        //These two variables are for determining the second highest number of the array after it has been sorted.
        int arraySize = sortArray.length;
        int secondLargest = sortArray[arraySize - 2];

        return secondLargest;
    }

    public static String[] swapFirstAndLast(String[] arr) {

        int arraySize = arr.length;
        String firstVal = arr[0];
        String lastVal = arr[arraySize - 1];
        String[] swappedArray = new String[arraySize];

        swappedArray[0] = lastVal;
        swappedArray[arraySize - 1] = firstVal;

        for (int i = 1; i < arraySize; i++) {
            if (i != arraySize - 1) {
                swappedArray[i] = arr[i];
            }

        }

        return swappedArray;

    }


    public static int[] reverse(int[] arr) {

        //initialized values
        int arraySize = arr.length;
        int[] reversedArr = new int[arraySize];

        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arraySize - i - 1];
        }

        return reversedArr;

    }

    public static String concatenateString(String[] arr) {
        String concatArr = "";

        for (String elements : arr) {
            concatArr = concatArr + elements;
        }
        return concatArr;
    }

    public static int[] everyThird(int[] arr) {
        int arraySize = arr.length;

        int thirdsArraySize = arraySize / 3;
        System.out.println(thirdsArraySize);
        int[] thirds = new int[thirdsArraySize];

        if (arraySize < 3) {
            return null;
        } else {
            for (int i = 2; i < thirdsArraySize; i = i + 3) {

                int temp = arr[i];
                for (int q = 0; q < thirdsArraySize; q++) {
                    thirds[q] = temp;
                    System.out.println("Third array" + thirds[q]);
                }
            }
        }

        return thirds;
    }

    public static int[] lessThanFive(int[] arr) {
        //determine the length of the new array.
        int arrayLength = arr.length;
        int fiveLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 5) {
                fiveLength += 1;
            }
        }

        if (fiveLength == 0) {
            return null;
        } else {
            int[] fiveBelow = new int[fiveLength];

            for (int q = 0; q < arr.length; q++) {
                int temp = arr[q];
                if (temp < 5) {
                    fiveBelow[q] = temp;
                }
            }

            return fiveBelow;
        }
    }


    public static void main(String[] args) {
        System.out.println("Using this as a test case.");
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] testArrayS = {"Ryu", "Ken", "Akuma"};
        System.out.println(everyThird(testArray));
    }

}
