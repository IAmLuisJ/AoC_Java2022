import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7 {

    public static void main(String[] args) throws Exception {
        File input = new File("/Users/luisjuarez/GitHub/AoC_Java2022/src/data/day7ex.txt");
        Scanner scanner = new Scanner(input);
        ArrayList<String> moves = new ArrayList<String>();
        ArrayList<Directory> fileTree = new ArrayList<>();

        int answer = 0;
        String currentDir = "/";

        while (scanner.hasNext()) {
            String thisMove = scanner.nextLine();
            System.out.println(thisMove);
            moves.add(thisMove);
            String[] part = thisMove.split(" ");
            if (part[0].equals("$")) {
                // it is a command
                // parse the argument
                if (part[1].equals("cd")) {
                    // cd - change directory to part 3
                    currentDir = part[2];

                } else if (part[1].equals("ls")) {
                    Directory newDir = new Directory(currentDir);
                    // ls
                    // take the following
                    // peek nextLine before breaking
                    if (part[0].equals("dir")) {
                        // dir
                        newDir.subDirs.add(new Directory(part[1]));
                    } else {
                        newDir.size += Integer.parseInt(part[0]);
                        newDir.files.add(part[1]);
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

        for (String move : moves) {
            String[] part = move.split(" ");

        }
        scanner.close();
        System.out.println(answer);
    }
}
