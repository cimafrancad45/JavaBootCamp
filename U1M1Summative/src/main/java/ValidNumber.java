import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int userInput;

        System.out.println("Please enter a number between 1 and 10.");
        userInput = Integer.parseInt(myScanner.nextLine());

        if (userInput < 1 || userInput > 10) {
            do {
                System.out.println("You must enter a number between 1 and 10, please try again.");
                userInput = Integer.parseInt(myScanner.nextLine());

            } while (userInput < 1 || userInput > 10);
            System.out.println("User Input: " + userInput);
        } else {
            System.out.println("User input: " + userInput);
        }


    }
}
