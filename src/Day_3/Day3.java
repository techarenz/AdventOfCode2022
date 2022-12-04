package Day_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day3 {

    public static void main(String[] args) throws FileNotFoundException {

//        String filename = "src/Day_3/input";
//        int challengeOneAnswer = challengeOne(filename);
//        System.out.println("Challenge One Answer: " + challengeOneAnswer);
//        int challengeTwoAnswer = challengeTwo(filename);
//        System.out.println("Challenge Two Answer: " + challengeTwoAnswer);

        String myString = "foward 5";
        String[] first = myString.split("");
        String[] second = myString.split(" ");

        for (String str: first) System.out.println(str);
        System.out.println();
        System.out.println();
        for (String str: second) System.out.println(str);
    }

    public static int challengeTwo(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int priorityTotal = 0;
        int elves = 0;
        String[] rucksacks = new String[3];
        while(scanner.hasNextLine()) {
            rucksacks[elves++] = scanner.nextLine();
            if (elves == 3) {
                priorityTotal += calculatePriorityOfGroup(rucksacks);
                elves = 0;
            }
        }
        return priorityTotal;
    }

    public static int calculatePriorityOfGroup(String[] group) {
        char badge = getBadge(group);
        return calculatePriority(badge);
    }

    public static char getBadge(String[] group) {
        HashMap<Character, Integer> items = new HashMap<>();
        char badge = 0;
        //int priority = 0;
        char[] elfA = group[0].toCharArray();
        char[] elfB = group[1].toCharArray();
        char[] elfC = group[2].toCharArray();

        for (char item: elfA) {
            if (!items.containsKey(item)) {
                items.put(item,1);
            }
        }
        for (char item: elfB) {
            if (items.containsKey(item)) {
                items.put(item, 2);
            }
        }
        for (char item: elfC) {
            if (items.containsKey(item) && items.get(item) == 2) {
                badge = item;
            }
        }
        return badge;
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
                System.out.print(item + " ");
                // Here we know that the item exists in both compartments, so we can calculate the priority of the element.
                rucksackPriority += calculatePriority(item);
                items.put(item, items.get(item) + 1);
            }
        }
        System.out.println("Rucksack Priority: " + rucksackPriority);
        return rucksackPriority;
    }

    private static int calculatePriority(char item) {
        if (item >= 97) return item - 96;
        return item - 38;
    }
}
