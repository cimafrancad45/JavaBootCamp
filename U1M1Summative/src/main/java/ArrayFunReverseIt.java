public class ArrayFunReverseIt {
    public int[] reverseIt () {
        int arr[] = {1, 2, 3, 4, 5};
        int arrLength = arr.length;
        int reverseArr[] = new int[arrLength];
        int newArrLength = arrLength;

        System.out.println("Original Array:");

        for (int i = 0; i < arrLength; i++) {
            System.out.println(arr[i]);
            reverseArr[newArrLength - 1] = arr[i];
            newArrLength = newArrLength - 1;
        }

        System.out.println("Reversed Array: ");
        for (int q = 0; q < arrLength; q++) {
            System.out.println(reverseArr[q]);
        }
        return reverseArr;
    }
}
