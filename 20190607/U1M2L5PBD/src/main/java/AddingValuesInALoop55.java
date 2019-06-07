import java.util.Scanner;

public class AddingValuesInALoop55 {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int Num;

        System.out.println("Enter a number, I'll keep adding until you press zero.");
        Num = Integer.parseInt(myScanner.nextLine());

        while (Num != 0) {

            System.out.println("Number: " + Num);
            int newNum = Integer.parseInt(myScanner.nextLine());
            if (newNum ==0) {
                Num = 0;
            } else {
                Num = Num + newNum;
            }

        }
    }
}
