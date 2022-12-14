import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day10 {
    public static void main(String[] args) throws Exception {
        File input = new File("/Users/luisjuarez/GitHub/AoC_Java2022/data/Day10.txt");
        Scanner myScanner = new Scanner(input);
        ArrayList<String> instructions = new ArrayList<>();
        int cycle = 0;
        int registerValue =1;
        int sum = 0;
        ArrayList<Integer> total = new ArrayList<>();

        while (myScanner.hasNext()) {
            String line = myScanner.nextLine();
            instructions.add(line);

        }

        for (String line : instructions) {
           // System.out.println(line);
            String[] parts = line.split(" ");
            if (parts[0].equals("noop")) {
                cycle++;
                if(cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220 ) {
                    System.out.println("signal strength: " + (cycle*registerValue));
                    System.out.println("cycle: "+cycle + " " + registerValue);
                    total.add(cycle*registerValue);
                }
            } else {
                int add = Integer.parseInt(parts[1]);
                for (int i = 0; i < 2; i++) {
                    cycle++;
                    if(cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220 ) {
                        System.out.println("signal strength " + (cycle*registerValue));
                        System.out.println("cycle: "+cycle + " " + registerValue);
                        total.add(cycle*registerValue);
                    }
                }
                registerValue += add;
            }
        }

        for (Integer num :
                total) {
            sum += num;
        }
        System.out.println("answer is " + sum);
        myScanner.close();
    }

}
