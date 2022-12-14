import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:\\Users\\a1016060\\GitHub\\AoC_Java2022\\src\\data\\Day5.txt");
        Scanner scanner = new Scanner(input);
        ArrayList<String> moves = new ArrayList<String>();
        ArrayList<ArrayList<String>> stacks = new ArrayList<>();

        boolean prelinebreak = true;

        // manual parse
        stacks.add(new ArrayList<>(Arrays.asList("P", "G", "R", "N")));
        stacks.add(new ArrayList<>(Arrays.asList("C", "D", "G", "F", "L", "B", "T", "J")));
        stacks.add(new ArrayList<>(Arrays.asList("V", "S", "M")));
        stacks.add(new ArrayList<>(Arrays.asList("P", "Z", "C", "R", "S", "L")));
        stacks.add(new ArrayList<>(Arrays.asList("Q", "D", "W", "C", "V", "L", "S", "P")));
        stacks.add(new ArrayList<>(Arrays.asList("S", "M", "D", "W", "N", "T", "C")));
        stacks.add(new ArrayList<>(Arrays.asList("P", "W", "G", "D", "H")));
        stacks.add(new ArrayList<>(Arrays.asList("V", "M", "C", "S", "H", "P", "L", "Z")));
        stacks.add(new ArrayList<>(Arrays.asList("Z", "G", "W", "L", "F", "P", "R")));

        while (scanner.hasNext()) {
            String thisLine = scanner.nextLine();
            if (thisLine.isEmpty()) {
                prelinebreak = false;
                continue;
            }
            if (prelinebreak) {
                // System.out.println(thisLine);
                // set lines
                // parse lines
                // String[] cratesStrings = thisLine.split("");
                // System.out.println("pause");
                // for (int i = 0; i < cratesStrings.length; i++) {
                // if(cratesStrings[i].equals("\\[")) {
                // crate.set(i, cratesStrings[i+1]);
                // }
                // }
            } else {
                // lines

                System.out.println(thisLine);
                moves.add(thisLine);
            }
        }
        // lines are scanned
        // set an array here for each column

        // read in the instruction
        for (String moveString : moves) {
            String[] instruction = moveString.split(" ");
            int move = Integer.parseInt(instruction[1]);
            int from = Integer.parseInt(instruction[3]);
            int to = Integer.parseInt(instruction[5]);

            for (int i = 0; i < move; i++) {
                String topLetter = stacks.get(from - 1).get(0);
                stacks.get(from - 1).remove(0);
                stacks.get(to - 1).add(topLetter);
                Collections.rotate(stacks.get(to - 1), 1);
            }

        }
        // movement should be a function since it moves once at a time
        for (ArrayList<String> stack : stacks) {
            System.out.println(stack.get(0));
        }
        scanner.close();
    }
}
