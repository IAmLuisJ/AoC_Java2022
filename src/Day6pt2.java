import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6pt2 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:\\Users\\a1016060\\GitHub\\AoC_Java2022\\src\\data\\Day6.txt");
        Scanner scanner = new Scanner(input);
        @SuppressWarnings("unused")
        boolean repeat = false;

        String inputString = "";

        while (scanner.hasNext()) {
            String thisMove = scanner.nextLine();
            inputString = thisMove;
        }

        String[] signals = inputString.split("");
        for (int i = 13; i < signals.length; i++) {
            if (!compareLastX(14, signals, i)) {
                System.out.println(i + 1);
                break;
            }
        }
        scanner.close();
    }

    public static boolean compareLastX(int x, String[] mylist, int start) {
        if (x < 1) {
            return false;
        } else {
            for (int i = 1; i < x; i++) {
                if (mylist[start].equals(mylist[start - i])) {
                    return true;
                }
            }
        }
        return compareLastX(x - 1, mylist, start - 1);
    }
}
