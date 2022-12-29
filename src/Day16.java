import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeMap;

public class Day16 {
    public static void main(String[] args) throws Exception {
        File input = new File("C:\\Users\\a1016060\\GitHub\\AoC_Java2022\\src\\data\\Day16.txt");
        Scanner scanner = new Scanner(input);
        ArrayList<String> moves = new ArrayList<String>();
        TreeMap<String, Integer> valves = new TreeMap<>();
        int minutes = 30;
        int sum = 0;
        ArrayList<Integer> total = new ArrayList<>();
        TreeMap<String, String[]> nextMap = new TreeMap<>();

        while (scanner.hasNext()) {
            String thisMove = scanner.nextLine();
            // System.out.println(thisMove);
            moves.add(thisMove);
        }
        try {
            for (String move : moves) {
                // parse valves
                String vLetter = move.split(" ")[1];
                Integer flowRate = Integer.parseInt(move.split("=")[1].split(";")[0]);
                valves.put(vLetter, flowRate);
                String nextValves = move.split("valves\\s*")[1];
                String[] eachValve = nextValves.split("\\s*,\\s*");

                // map valve to next available nodes
                nextMap.put(vLetter, eachValve);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String bestValveToOpen = valves.firstKey();
        // each minute make a move
        for (int i = 0; i < 30; i++) {
            String nextBestValveToOpen = checkValves(valves, nextMap, bestValveToOpen);
            if (!bestValveToOpen.equals(nextBestValveToOpen)) {
                minutes--;
            }
            bestValveToOpen = nextBestValveToOpen;
            minutes--;
            total.add(valves.get(bestValveToOpen) * minutes);
        }

        // add up pressure
        for (Integer num : total) {
            sum += num;
        }

        System.out.println(sum);
        scanner.close();
    }

    public static String checkValves(TreeMap<String, Integer> valves, TreeMap<String, String[]> nextMap, String valve) {
        String currentValve = valve;
        // compare opening the valve to moving to next valve
        int currentValvePressure = valves.get(currentValve);
        int nextValvePressure = 0;
        String nextStep = "";
        String[] otherValves = nextMap.get(currentValve);
        for (String nextValve : otherValves) {
            int thisPressure = valves.get(nextValve);
            if (thisPressure > nextValvePressure) {
                nextValvePressure = thisPressure;
                nextStep = nextValve;
            }
        }
        if (currentValvePressure > nextValvePressure) {
            return currentValve;
        } else {
            // spend a minute moving to next valve
            // open next valve
        }
        return nextStep;
    }
}
