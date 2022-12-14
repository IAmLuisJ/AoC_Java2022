import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Day7 {
    public static void main(String[] args) throws Exception {
        File input = new File("C:\\Users\\a1016060\\GitHub\\AoC_Java2022\\src\\data\\Day7ex.txt");
        Scanner scanner = new Scanner(input);
        ArrayList<String> moves = new ArrayList<String>();
        Map<Integer, String> fileMap = new TreeMap<>();
        int answer = 0;

        while (scanner.hasNext()) {
            String thisMove = scanner.nextLine();
            System.out.println(thisMove);
            moves.add(thisMove);
        }

        for (String move : moves) {
            String[] part = move.split(" ");
            if (part[0].equals("$")) {
                // it is a command
                // parse the argument
                if (part[1].equals("cd")) {
                    // cd - change directory to part 3
                    String newPath = part[2];

                } else if (part[1].equals("ls")) {
                    // ls
                }
            } else {
                // first part is file size, second part is filename and extension

            }
        }
        scanner.close();
        System.out.println(answer);
    }
}
