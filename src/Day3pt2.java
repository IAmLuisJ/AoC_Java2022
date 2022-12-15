import java.io.File;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Day3pt2 {
    public static void main(String[] args) throws Exception {
        File input = new File("C:\\Users\\luisi\\OneDrive\\Desktop\\Day2\\src\\data\\input2.txt");
        Scanner myScanner = new Scanner(input);

        ArrayList<Integer> total = new ArrayList<>();
        int totalScore = 0;
        while (myScanner.hasNext()) {
            String line1 = myScanner.nextLine();
            String line2 = myScanner.nextLine();
            String line3 = myScanner.nextLine();

            String[] sack1 = line1.split("");
            String[] sack2 = line2.split("");
            String[] sack3 = line3.split("");

            Set<String> letters = new HashSet<>();
            for (String item1 : sack1) {
                for (String item2 : sack2) {
                    if (item1.equals(item2)) {
                        for (String item3 : sack3) {
                            if (item2.equals(item3)) {
                                letters.add(item3);
                            }
                        }
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
