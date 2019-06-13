import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        SomeMath math = new SomeMath();
        ArrayFunUserArray userArr = new ArrayFunUserArray();
        ArrayFunReverseIt reverse = new ArrayFunReverseIt();
        ArrayFun5Words fiveWords = new ArrayFun5Words();

        System.out.println("Method total 5: ");
        System.out.println(math.total5(1,2,3,4,5) + "\n");

        System.out.println("Method average 5: ");
        System.out.println(math.average5(1,3,5,7,9) + "\n");

        System.out.println("Method largest 5:");
        System.out.println(math.largest5(42.0,35.1,2.3,40.2,15.6) + "\n");

        //declaring variables for the following methods
        int inputNum1;
        int inputNum2;
        int inputNum3;
        int inputNum4;
        int inputNum5;

        String inputStr1;
        String inputStr2;
        String inputStr3;
        String inputStr4;
        String inputStr5;

        System.out.println("New array method:");
        System.out.println("Please put in five integer numbers:");
        System.out.println("First Number: ");
        inputNum1= Integer.parseInt(myScanner.nextLine());
        System.out.println("Second Number: ");
        inputNum2= Integer.parseInt(myScanner.nextLine());
        System.out.println("Third Number: ");
        inputNum3= Integer.parseInt(myScanner.nextLine());
        System.out.println("Fourth Number: ");
        inputNum4= Integer.parseInt(myScanner.nextLine());
        System.out.println("Fifth Number: ");
        inputNum5= Integer.parseInt(myScanner.nextLine());

        System.out.println("\nYour array values are: ");
        userArr.newUserArray(inputNum1,inputNum2,inputNum3,inputNum4,inputNum5);



        System.out.println("\nReversed array method:");
        reverse.reverseIt();

        System.out.println("\nString array method");
        System.out.println("Please enter five strings: ");
        System.out.println("First String: ");
        inputStr1= myScanner.nextLine();
        System.out.println("Second String: ");
        inputStr2= myScanner.nextLine();
        System.out.println("Third String: ");
        inputStr3= myScanner.nextLine();
        System.out.println("Fourth String: ");
        inputStr4= myScanner.nextLine();
        System.out.println("Fifth String: ");
        inputStr5= myScanner.nextLine();
        System.out.println("Your array values are: ");
        fiveWords.return5Words(inputStr1, inputStr2, inputStr3, inputStr4, inputStr5);


    }

}
