package Day_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "src/Day_4/input";
        int challengeOneAnswer = challengeOne(filename);
        System.out.println("Challenge One Answer: " + challengeOneAnswer);
        int challengeTwoAnswer = challengeTwo(filename);
        System.out.println("Challenge Two Answer: " + challengeTwoAnswer);
    }

    public static int challengeTwo(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int containsCounter = 0;
        while (scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split(",");
            String elfA = input[0];
            String elfB = input[1];
            String[] elfARange = elfA.split("-");
            String[] elfBRange = elfB.split("-");

            int elfALow = Integer.parseInt(elfARange[0]);
            int elfAHigh = Integer.parseInt(elfARange[1]);

            int elfBLow = Integer.parseInt(elfBRange[0]);
            int elfBHigh = Integer.parseInt(elfBRange[1]);

            if (containsRange(elfALow,elfAHigh,elfBLow,elfBHigh)) containsCounter++;

        }
        return containsCounter;
    }

    public static int challengeOne(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int containsCounter = 0;

        while(scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split(",");
            String elfA = input[0];
            String elfB = input[1];
            String[] elfARange = elfA.split("-");
            String[] elfBRange = elfB.split("-");

            int elfALow = Integer.parseInt(elfARange[0]);
            int elfAHigh = Integer.parseInt(elfARange[1]);

            int elfBLow = Integer.parseInt(elfBRange[0]);
            int elfBHigh = Integer.parseInt(elfBRange[1]);

            if (containsEntireRange(elfALow, elfAHigh, elfBLow, elfBHigh)) containsCounter++;
        }
        return containsCounter;
    }

    private static boolean containsEntireRange(int aLow, int aHigh, int bLow, int bHigh) {
        return ((aLow >= bLow && aHigh <= bHigh) || (bLow >= aLow && bHigh <= aHigh));
    }

    private static boolean containsRange(int aLow, int aHigh, int bLow, int bHigh) {
        return !(aLow > bHigh || aHigh < bLow);
    }
}
