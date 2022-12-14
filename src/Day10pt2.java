import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day10pt2 {
    static int cycle;
    static int registerValue;
    static int rowCount = 0;
    static int horizontal = 0;

    public static void increment() {
        cycle++;
        if(registerValue == horizontal || (registerValue+1) == horizontal || (registerValue+2) == horizontal) {
            //print here?
            System.out.print("#");
            //row.set(cycle, "#");
        } else {
            System.out.print(".");
            // row.set(cycle, ".");
        }
        moveCursor();
    }

    public static void moveCursor(){
        horizontal++;
        if (horizontal >= 40) {
            rowCount++;
            horizontal = 0;
            System.out.println(rowCount);
        }
    }

    public static void main(String[] args) throws Exception {
        File input = new File("/Users/luisjuarez/GitHub/AoC_Java2022/data/Day10.txt");
        Scanner myScanner = new Scanner(input);
        ArrayList<String> instructions = new ArrayList<>();
        int sum = 0;
        ArrayList<Integer> total = new ArrayList<>();
        ArrayList<ArrayList<String>> CRT = new ArrayList<>();
        ArrayList<String> row = new ArrayList<>();


        //parse
        while (myScanner.hasNext()) {
            String line = myScanner.nextLine();
            instructions.add(line);
        }

        for (String line : instructions) {
           // System.out.println(line);
            String[] parts = line.split(" ");
            if (parts[0].equals("noop")) {
                increment();
            } else {
                int add = Integer.parseInt(parts[1]);
                increment();
                increment();
                registerValue += add;
            }
        }

       //System.out.println("answer is " + cycle);
        myScanner.close();
    }

}
