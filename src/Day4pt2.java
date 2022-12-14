import java.io.File;
import java.util.Scanner;

public class Day4pt2 {
    public static void main(String[] args) throws Exception {
        File input = new File("src\\data\\Day4input.txt");
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
            if (leftLow >= rightLow && leftLow <= rightHigh) {
                counter++;
            }
            // compare right in left
            else if (rightLow >= leftLow && rightLow <= leftHigh) {
                counter++;
            }
        }
        System.out.println(counter);
        scanner.close();
    }
}
