import java.util.Random;

public class ShorterDoubleDice58 {

    public static void main(String[] args) {
        Random random = new Random();
        int rollValue1;
        int rollValue2;


        do {
            rollValue1 = random.nextInt(6) + 1;
            rollValue2 = random.nextInt(6) + 1;
            int totalRoll = rollValue1 + rollValue2;
            System.out.println("\nRoll 1: " + rollValue1);
            System.out.println("Roll 2: " + rollValue2);
            System.out.println("\nTotal roll: " + totalRoll);
        } while (rollValue1 != rollValue2);
    }
}
