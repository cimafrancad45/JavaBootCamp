import java.util.Scanner;

public class RightTriangleChecker61 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int sideOne;
        int sideTwo;
        int sideThree;

        /*

        code for user input for each of the sides. If following integer inputted is larger than the previous input,
        Loop prompts user to put in another value.
        */
        System.out.println("Enter three integers.");
        System.out.println("Side 1: ");
        sideOne = Integer.parseInt(myScanner.nextLine());

        System.out.println("Side 2: ");
        sideTwo = Integer.parseInt(myScanner.nextLine());
        if (sideTwo < sideOne) {
            while (sideOne > sideTwo) {
                System.out.println(sideOne + " is smaller than " + sideTwo + " try a different number.");
                sideTwo = Integer.parseInt(myScanner.nextLine());
            }
        }
        System.out.println("Side 3: ");
        sideThree = Integer.parseInt(myScanner.nextLine());
        if (sideThree < sideTwo) {
            while (sideTwo > sideThree) {
                System.out.println(sideTwo + " is smaller than " + sideThree + " try a different number.");
                sideThree = Integer.parseInt(myScanner.nextLine());
            }
        }
        //pythagorean theorem formula to check if the sides can make a right triangle.
        double pythagorean1 = sideOne^2 + sideThree^2;
        double pythagorean2 = sideThree^2;

        if (pythagorean1 == pythagorean2){
            System.out.println("Your measurements make a right triangle!");
        } else {
            System.out.println("Your measurements cannot make a right triangle.");
        }

    }
}
