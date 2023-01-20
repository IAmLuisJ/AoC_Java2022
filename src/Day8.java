import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {

    public static void main(String[] args) throws Exception {
        File input = new File("/Users/luisjuarez/GitHub/AoC_Java2022/src/data/daay8ex.txt");
        Scanner scanner = new Scanner(input);

        int answer = 0;

        while (scanner.hasNext()) {
            String thisMove = scanner.nextLine();
            System.out.println(thisMove);
        }

        scanner.close();
        System.out.println(answer);
}
}
