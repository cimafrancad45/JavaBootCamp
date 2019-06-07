import java.util.Scanner;

public class SafeSquareRoot60 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int userNum;

        System.out.println("SAFE SQUARE ROOT!");
        System.out.println("Enter a number: ");
        userNum = Integer.parseInt(myScanner.nextLine());
        if (userNum > 0) {
            double sqNum = Math.sqrt(userNum);
            System.out.println("The square root of " + userNum + " is " + sqNum);
        } else {
            while (userNum <= -1) {
                System.out.println("YOU FOOL! You can't get the square root a negative!.");
                System.out.println("Enter a number:");
                userNum = Integer.parseInt(myScanner.nextLine());
                if (userNum > 0) {
                    double sqNum = Math.sqrt(userNum);
                    System.out.println("The square root of " + userNum + " is " + sqNum);
                }
            }
        }
    }
}