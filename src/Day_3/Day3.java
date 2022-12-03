package Day_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day3 {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "src/Day_3/testInput";
        int challengeOneAnswer = challengeOne(filename);
        System.out.println("Challenge One Answer: " + challengeOneAnswer);
    }

    public static int challengeOne(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int priorityTotal = 0;
        while (scanner.hasNextLine()) {
            String rucksack = scanner.nextLine();
            priorityTotal += calculateRucksackPriority(rucksack);
        }
        return priorityTotal;
    }

    private static int calculateRucksackPriority(String rucksack) {
        int rucksackPriority = 0;
        HashMap<Character, Integer> items = new HashMap();
        int numberOfItems = rucksack.length();
        String compartmentA = rucksack.substring(0,numberOfItems/2);
        String compartmentB = rucksack.substring(numberOfItems/2);
        char[] compartmentACharArray = compartmentA.toCharArray();
        char[] compartmentBCharArray = compartmentB.toCharArray();
        for (char item: compartmentACharArray) {
            if (!items.containsKey(item)) items.put(item,1);
        }
        for (char item: compartmentBCharArray) {
            if (items.containsKey(item) && items.get(item) == 1) {
                // Here we know that the item exists in both compartments, so we can calculate the priority of the element.
                rucksackPriority += calculatePriority(item);
                items.put(item, items.get(item) + 1);
            }
        }
        System.out.println("Rucksack Priority: " + rucksackPriority);
        return rucksackPriority;
    }

    private static int calculatePriority(char item) {
        int priority = item - 96;
        if (priority < 0) return Math.abs(priority+4);
        return priority;
    }
}
