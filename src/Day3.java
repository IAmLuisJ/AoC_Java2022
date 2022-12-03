import java.io.File;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Day3 {
    public static void main(String[] args) throws Exception {
        File input = new File("C:\\Users\\luisi\\OneDrive\\Desktop\\Day2\\src\\input2.txt");
        Scanner myScanner = new Scanner(input);
        ArrayList<Integer> total = new ArrayList<>();
        int totalScore = 0;

        while (myScanner.hasNext()) {

            String thisMove = myScanner.nextLine();

            String compartment1 = thisMove.substring(0, (thisMove.length() / 2));
            String compartment2 = thisMove.substring((thisMove.length() / 2));

            String[] leftSide = compartment1.split("");
            String[] rightSide = compartment2.split("");

            Set<String> letters = new HashSet<>();
            for (String leftItem : leftSide) {
                for (String rightItem : rightSide) {
                    if (leftItem.equals(rightItem)) {
                        letters.add(leftItem);
                    }
                }
            }

            for (String repeat : letters) {
                for (char letter : repeat.toCharArray()) {
                    int val = 0;
                    if (Character.isUpperCase(letter)) {
                        val = letter - 38;
                        total.add(val);
                        totalScore = totalScore + val;
                    } else {
                        val = letter - 96;
                        total.add(val);
                        totalScore = totalScore + val;
                    }
                    System.out.println(letter);
                    System.out.println(val);
                }
            }

        }
        System.out.println(totalScore);
        myScanner.close();
    }

}
