import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Day21 {

    public static void main(String[] args) throws Exception {
        File input = new File("/Users/luisjuarez/GitHub/AoC_Java2022/data/Day21.txt");
        Scanner myScanner = new Scanner(input);
        ArrayList<String> instructions = new ArrayList<>();
        TreeMap<String, Long> monkeyList = new TreeMap<String, Long>();
        DecimalFormat formatter = new DecimalFormat();
        TreeMap<String, String> unSolvedFormulas = new TreeMap<>();

        boolean foundValue = true;

        while (myScanner.hasNext()) {
            String line = myScanner.nextLine();
            instructions.add(line);

        }

        for (String line : instructions) {
            // System.out.println(line);
            String[] parts = line.split(":");
            String monkeyName = parts[0];
            // parse the second part
            String monkeyVal = parts[1];
            try {
                long monkeyNumber = Long.parseLong(parts[1].trim());
                monkeyList.put(monkeyName, monkeyNumber);
            } catch (Exception e) {
                // System.out.println(e.getMessage());
                unSolvedFormulas.put(monkeyName, monkeyVal);
            }
        }
        monkeyList.put("humn", 3782852515583L);
        // loop again until we find out root value
        while (foundValue) {

            for (Map.Entry<String, String> monkey : unSolvedFormulas.entrySet()) {
                // loop through formula to see if we have answers
                String monkeyFormula = monkey.getValue();
                String monkey1 = monkeyFormula.substring(1, 5);
                String sign = monkeyFormula.substring(6, 7);
                String monkey2 = monkeyFormula.substring(8, 12);

                if (monkey.getKey().equals("root")) {
                    sign = "=";
                }

                if (monkeyList.containsKey(monkey1) && monkeyList.containsKey(monkey2)) {
                    long val1 = monkeyList.get(monkey1);
                    long val2 = monkeyList.get(monkey2);
                    if (sign.equals("+")) {
                        long answer = Math.addExact(val1, val2);
                        monkeyList.put(monkey.getKey(), answer);
                    } else if (sign.equals("-")) {
                        long answer = Math.subtractExact(val1, val2);
                        monkeyList.put(monkey.getKey(), answer);
                    } else if (sign.equals("*")) {
                        long answer = Math.multiplyExact(val1, val2);
                        monkeyList.put(monkey.getKey(), answer);
                    } else if (sign.equals("/")) {
                        long answer = val1 / val2;
                        monkeyList.put(monkey.getKey(), answer);
                    } else if (sign.equals("=")) {
                        if (val1 == val2) {
                            System.out.println("equality passed");
                            foundValue = false;
                        } else {
                            System.out.println("equality failed");
                            foundValue = false;
                            System.out.println(formatter.format(val1));
                            System.out.println(formatter.format(val2));

                            System.out.println(formatter.format(val1 - val2));
                        }
                        // monkeyList.put("root", 1L);
                    }
                }
            }
        }

        // System.out.println(monkeyList.get("root"));
        myScanner.close();
    }
}
