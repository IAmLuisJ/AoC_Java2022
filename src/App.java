import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        File input = new File("C:\\Users\\luisi\\OneDrive\\Desktop\\Day2\\src\\input.txt");
        Scanner scanner = new Scanner(input);
        ArrayList<String> move = new ArrayList<String>();
        int answer = 0;

        while (scanner.hasNext()) {

            String thisMove = scanner.nextLine();
            System.out.println(thisMove);
        }
        System.out.println(answer);
    }
}
