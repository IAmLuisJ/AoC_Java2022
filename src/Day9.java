import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9 {
    public static void main(String[] args) throws Exception {
        File input = new File("C:\\Users\\a1016060\\GitHub\\AoC_Java2022\\src\\data\\Day9.txt");
        Scanner scanner = new Scanner(input);
        ArrayList<String> moves = new ArrayList<String>();
        int answer = 0;
        Head planckhHead = new Head();
        Tail planckTail = new Tail();
        Tail newTail = new Tail();
        Tail newTail2 = new Tail();
        Tail newTail3 = new Tail();
        Tail newTail4 = new Tail();
        Tail newTail5 = new Tail();
        Tail newTail6 = new Tail();
        Tail newTail7 = new Tail();
        Tail newTail8 = new Tail();

        System.out.println("Start");
        System.out.println("");

        while (scanner.hasNext()) {
            String thisMove = scanner.nextLine();
            // System.out.println(thisMove);
            moves.add(thisMove);
        }

        for (String move : moves) {
            String[] instruction = move.split(" ");
            String direction = instruction[0];
            int steps = Integer.parseInt(instruction[1]);

            for (int i = 0; i < steps; i++) {
                // move the H along the grid
                // H and S start at 0, touching
                // System.out.println(direction);
                planckhHead.MoveHead(direction);
                planckTail.followHead(planckhHead);
                newTail.followTail(planckTail);
                newTail2.followTail(newTail);
                newTail3.followTail(newTail2);
                newTail4.followTail(newTail3);
                newTail5.followTail(newTail4);
                newTail6.followTail(newTail5);
                newTail7.followTail(newTail6);
                newTail8.followTail(newTail7);

                // print(planckhHead, planckTail);
            }
        }
        answer = newTail8.visited.size();
        System.out.println(answer);
        scanner.close();
    }

    public static void print(Head front, Tail back) {
        System.out.println(" ");
        System.out.println("Grid");
        System.out.println("");
        for (int i = 6; i >= 0; i--) {
            System.out.println();
            for (int j = 0; j <= 6; j++) {
                if (i == front.yCoord && j == front.xCoord) {
                    System.out.print("H");
                } else if (i == back.tailY && j == back.tailX) {
                    System.out.print("T");
                } else {
                    System.out.print(".");
                }
            }

        }
    }

}
