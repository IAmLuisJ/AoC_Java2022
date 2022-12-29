import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7 {

    class directory {
        String dirName = "";

    }

    public static void main(String[] args) throws Exception {
        File input = new File("C:\\Users\\a1016060\\GitHub\\AoC_Java2022\\src\\data\\Day7ex.txt");
        Scanner scanner = new Scanner(input);
        ArrayList<String> moves = new ArrayList<String>();

        int answer = 0;
        String currentDir = "/";

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
                    // String newPath = part[2];

                } else if (part[1].equals("ls")) {
                    // ls
                    // take the following
                    if (part[0].equals("dir")) {
                        // dir
                    }
                }
            } else {
                // first part is file size, second part is filename and extension
                try {
                    // parse
                    int fileSize = Integer.parseInt(part[0]);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        scanner.close();
        System.out.println(answer);
    }
}
