import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6 {

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:\\Users\\a1016060\\GitHub\\AoC_Java2022\\src\\data\\Day6.txt");
        Scanner scanner = new Scanner(input);
        @SuppressWarnings("unused")
        boolean repeat = false;
        int answer = 0;

        String inputString = "";

        while (scanner.hasNext()) {
            String thisMove = scanner.nextLine();
            inputString = thisMove;
        }

        String[] signals = inputString.split("");
        for (int i = 3; i < signals.length; i++) {

            String lastOne = signals[i - 1];
            String lastTwo = signals[i - 2];
            String lastThree = signals[i - 3];

            if (signals[i].equals(lastThree) || signals[i].equals(lastTwo) || signals[i].equals(lastOne)) {
                repeat = true;
            } else if (lastOne.equals(lastTwo) || lastOne.equals(lastThree)) {
                repeat = true;
            } else if (lastTwo.equals(lastThree)) {
                repeat = true;
            } else {
                answer = i;
                System.out.println(i);
            }

        }
        System.out.println(answer);
        scanner.close();
    }

    public boolean compareLastX(int x, String[] mylist) {
        for (int i = 0; i < x; i++) {
            if (mylist[i].equals(mylist[i - 1])) {
                return true;
            }
        }
        return false;
    }
}
