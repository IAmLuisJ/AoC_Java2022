import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;

public class Day23 {

    public static void main(String[] args) throws Exception {
        File input = new File("C:\\Users\\a1016060\\GitHub\\AoC_Java2022\\src\\data\\Day23ex.txt");
        Scanner myScanner = new Scanner(input);
        ArrayList<String> instructions = new ArrayList<>();
        int width = 0;
        int height = 0;
        ArrayList<coordinate> elves = new ArrayList<>();

        while (myScanner.hasNext()) {
            String line = myScanner.nextLine();
            instructions.add(line);
        }
        height = instructions.size();
        width = instructions.get(0).length();
        String[][] grove = new String[width][height];
        int lineCount = 0;
        for (String line : instructions) {
            String[] parts = line.split("");
            for (int i = 0; i < parts.length; i++) {
                grove[lineCount][i] = parts[i];
                if (parts[i].equals("#")) {
                    elves.add(new coordinate(lineCount, i));
                }
            }
            lineCount++;
        }
        printGrove(grove);
        myScanner.close();

        for (int round = 0; round < 10; round++) {
            // first half of round

            for (coordinate elf : elves) {
                // consider positions, if empty, pick a spot to move to

            }
            // second half of round
            // elf moves happen
            // if two elves move to the same position, neither elf mvoes

            // shift which direction to consider first.

            // after 10 rounds
            // consider the maxX and maxY and minX and minY
            // count the number of "." in that rectangle
        }

    }

    public static void printGrove(String[][] grove) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < grove[0].length; x++) {
            for (int y = 0; y < grove.length; y++) {
                sb.append(grove[x][y]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
