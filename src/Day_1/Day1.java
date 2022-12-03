package Day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "src/Day_1/input";
        int challengeOneAnswer = challengeOne(filename);
        System.out.println("Challenge 1: " + challengeOneAnswer);
        int challengeTwoAnswer = challengeTwo(filename);
        System.out.println("Challenge 2: " + challengeTwoAnswer);
    }

    public static int challengeOne(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int maximum = 0;
        int total = 0;

        while(scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.equals("")) {
                if (total > maximum) maximum = total;
                total = 0;
            }
            else {
                total += Integer.parseInt(nextLine);
            }

        }

        return maximum;

    }
    public static int challengeTwo(String filename) throws FileNotFoundException {
        int[] topThree = challengeTwoDriver(filename);
        return topThree[0] + topThree[1] + topThree[2];
    }
    private static int[] challengeTwoDriver(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int[] topThree = new int[3];
        int total = 0;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.equals("")) {
                checkAndSwap(topThree, total);
                total = 0;
            }
            else {
                total += Integer.parseInt(nextLine);
            }
        }
        checkAndSwap(topThree, total);
        return topThree;
    }
    private static void checkAndSwap(int[] topThree, int total) {
        if (total >= topThree[0]) {
            topThree[2] = topThree[1];
            topThree[1] = topThree[0];
            topThree[0] = total;
        }
        else if (total >= topThree[1]) {
            topThree[2] = topThree[1];
            topThree[1] = total;
        }
        else if (total >= topThree[2]) {
            topThree[2] = total;
        }
    }
}
