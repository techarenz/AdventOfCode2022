package Day_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "src/Day_2/input";
        int challengeOneAnswer = challengeOne(filename);
        System.out.println("Challenge One Answer: " + challengeOneAnswer);
        int challengeTwoAnswer = challengeTwo(filename);
        System.out.println("Challenge Two Answer: " + challengeTwoAnswer);
    }

    // Rock: A and X
    // Paper: B and Y
    // Scissors: C and Z

    // choiceA: opponent
    // choiceB: me

    public static int challengeOne(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int score = 0;
        while (scanner.hasNextLine()) {
            String[] round = scanner.nextLine().split(" ");
            String choiceA = round[0];
            String choiceB = round[1];
            score += getRoundScore(choiceA, choiceB);
        }
        return score;
    }

    private static int getRoundScore(String choiceA, String choiceB) {
        if (choiceA.equals("A")) {
            if (choiceB.equals("X")) return 4;
            if (choiceB.equals("Y")) return 8;
            else return 3;
        }
        else if (choiceA.equals("B")) {
            if (choiceB.equals("X")) return 1;
            if (choiceB.equals("Y")) return 5;
            else return 9;
        }
        else {
            if (choiceB.equals("X")) return 7;
            if (choiceB.equals("Y")) return 2;
            else return 6;
        }
    }

    public static int challengeTwo(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int score = 0;
        while (scanner.hasNextLine()) {
            String[] round = scanner.nextLine().split(" ");
            String choiceA = round[0];
            String decision = round[1];
            String choiceB = checkWhatToPlay(choiceA, decision);
            score += getRoundScore(choiceA, choiceB);
        }
        return score;
    }

    private static String checkWhatToPlay(String choiceA, String choiceB) {
        // must lose
        if (choiceB.equals("X")) {
            if (choiceA.equals("A")) return "Z";
            if (choiceA.equals("B")) return "X";
            else return "Y";
        }
        // must draw
        else if (choiceB.equals("Y")) {
            if (choiceA.equals("A")) return "X";
            if (choiceA.equals("B")) return "Y";
            else return "Z";
        }
        // must win
        else {
            if (choiceA.equals("A")) return "Y";
            if (choiceA.equals("B")) return "Z";
            else return "X";
        }
    }
}
