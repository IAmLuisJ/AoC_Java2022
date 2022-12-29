import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day14 {
    public static void main(String[] args) throws Exception {
        File input = new File("C:\\Users\\a1016060\\GitHub\\AoC_Java2022\\src\\data\\Day14.txt");
        Scanner myScanner = new Scanner(input);
        ArrayList<String> instructions = new ArrayList<>();
        ArrayList<ArrayList<coordinate>> cave = new ArrayList<>();
        int highestY = 0;

        // String[][] scan = new String[512][15];
        String[][] scan = new String[1000][162];
        while (myScanner.hasNext()) {
            String line = myScanner.nextLine();
            instructions.add(line);
        }

        for (String line : instructions) {
            // System.out.println(line);
            String[] parts = line.split("->");
            int distanceToRight = 0;
            int distanceDown = 0;
            ArrayList<coordinate> rockPath = new ArrayList<>();
            for (String thisLine : parts) {
                String[] xyParts = thisLine.split(",");
                distanceToRight = Integer.parseInt(xyParts[0].trim());
                distanceDown = Integer.parseInt(xyParts[1].trim());
                rockPath.add(new coordinate(distanceToRight, distanceDown));
            }
            cave.add(rockPath);
        }

        for (int y = 0; y < scan[0].length; y++) {
            for (int x = 0; x < scan.length; x++) {
                scan[x][y] = ".";
            }
        }
        try { // draw lines
            for (ArrayList<coordinate> path : cave) {
                // Track highest Y
                for (int i = 0; i < path.size() - 1; i++) {
                    if (path.get(i).y > highestY) {
                        highestY = path.get(i).y;
                    }
                    // if x == x2, then fill in y
                    if (path.get(i).x == path.get(i + 1).x) {
                        // figure out y difference
                        int difference = path.get(i + 1).y - path.get(i).y;
                        if (difference > 0) {
                            for (int j = 0; j <= difference; j++) {
                                scan[path.get(i).x][path.get(i).y + j] = "#";
                            }
                        } else {
                            for (int j = 0; j >= difference; j--) {
                                scan[path.get(i).x][path.get(i).y + j] = "#";
                            }
                        }
                    } else { // else fill in x difference
                        int difference = path.get(i + 1).x - path.get(i).x;
                        if (difference > 0) {
                            for (int j = 0; j <= difference; j++) {
                                scan[path.get(i).x + j][path.get(i).y] = "#";
                            }
                        } else {
                            for (int j = 0; j >= difference; j--) {
                                scan[path.get(i).x + j][path.get(i).y] = "#";
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // printCave(scan);
        // sand
        Sand drain = new Sand();
        boolean notClogged = true;
        while (notClogged) {
            notClogged = drain.GenerateSand(scan);
            printCave(scan);
            Thread.sleep(50);
        }
        System.out.println();
        System.out.println(highestY);

        myScanner.close();
    }

    public static void printCave(String[][] scan) {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < scan[0].length; y++) {
            for (int x = 480; x < Math.min(scan.length, 550); x++) {
                sb.append(scan[x][y]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
