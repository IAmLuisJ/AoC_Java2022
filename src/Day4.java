import java.io.File;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) throws Exception {
        File input = new File("src\\data\\Day4troy.txt");
        Scanner scanner = new Scanner(input);

        int counter = 0;

        while (scanner.hasNext()) {
            String thisMove = scanner.nextLine();
            // System.out.println(thisMove);
            String[] pairs = thisMove.split(",");
            String leftPair = pairs[0];
            String rightPair = pairs[1];

            int leftLow = Integer.parseInt(leftPair.split("-")[0]);
            int leftHigh = Integer.parseInt(leftPair.split("-")[1]);
            int rightLow = Integer.parseInt(rightPair.split("-")[0]);
            int rightHigh = Integer.parseInt(rightPair.split("-")[1]);

            // compare left in right
            if (leftLow >= rightLow && leftHigh <= rightHigh) {
                // then left is within
                counter++;
            }
            // compare right in left
            else if (rightLow >= leftLow && rightHigh <= leftHigh) {
                counter++;
            }
        }
        System.out.println(counter);
        scanner.close();
    }
}
