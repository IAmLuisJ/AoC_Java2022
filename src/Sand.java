import java.util.ArrayList;

public class Sand {
    int startX = 500;
    int startY = 0;
    ArrayList<coordinate> grains = new ArrayList<coordinate>();
    coordinate start = new coordinate(startX, startY);

    public Sand() {

    }

    public boolean GenerateSand(String[][] scan) {
        // produce one unit of sand
        coordinate grain = new coordinate(startX, startY);
        grain = tick(grain, scan);
        grains.add(grain);
        scan[grain.getX()][grain.getY()] = "o";
        // does not produce until previous sand comes to rest
        // if sand doesn't come to rest
        if (grain.equals(start)) {
            System.out.println("answer");
            System.out.println(grains.size());
            return false;
        }
        return true;
    }

    public coordinate tick(coordinate grain, String[][] scan) {
        int count = 0;
        boolean notResting = true;
        // Moves sand along and checks if unit has come to rest
        // Sand should fall down if possible
        try {
            while (notResting) {
                if (scan[grain.x][grain.y + 1].equals(".")) {
                    grain.setY(grain.getY() + 1);
                } else if (scan[grain.x - 1][grain.y + 1].equals(".")) { // if below is blocked by rock or sand, move
                                                                         // down and to the left
                    grain.setX(grain.getX() - 1);
                    grain.setY(grain.getY() + 1);
                    count = 0;

                } else if (scan[grain.x + 1][grain.y + 1].equals(".")) { // if down and left is blocked, move down and
                                                                         // right
                    grain.setX(grain.getX() + 1);
                    grain.setY(grain.getY() + 1);
                    count = 0;
                } else { // if all 3 spots are blocked, rest
                    notResting = false;
                    count = 0;
                }
                count++;
                if (count > 800) {
                    // System.out.println("this is falling too long");
                    // System.out.println(grains.size());
                    notResting = false;
                }
            }
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            // System.out.println("sand falling past bounds");
            // System.out.println(grains.size());
        }

        // if it can't rest after x ticks, early return?

        // return final coordinate resting position
        return grain;
    }
}
