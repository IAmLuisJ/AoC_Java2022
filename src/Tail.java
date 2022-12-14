import java.util.HashSet;
import java.util.Set;

public class Tail {
    int tailX = 0;
    int tailY = 0;
    Set<coordinate> visited = new HashSet<>();

    public int getTailX() {
        return tailX;
    }

    public int getTailY() {
        return tailY;
    }

    public void setTailX(int tailX) {
        this.tailX = tailX;
    }

    public void setTailY(int tailY) {
        this.tailY = tailY;
    }

    public Set<coordinate> getVisited() {
        return visited;
    }

    public int getVisitedCount() {
        return visited.size();
    }

    public void followHead(Head node) {
        // check if Head has moved more than 1 unit
        if (node.xCoord - tailX > 1) {
            if (node.yCoord - tailY > 0) {
                // need to move diagonal
                tailX++;
                tailY++;
            } else if (tailY - node.yCoord > 0) {
                tailX++;
                tailY--;
            } else {
                // move toward head
                tailX++;
            }
        } else if (tailX - node.xCoord > 1) { // H is left of T
            if (tailY - node.yCoord > 0) { // move diagonal
                tailX--;
                tailY--;
            } else if (node.yCoord - tailY > 0) {
                tailX--;
                tailY++;
            } else {
                tailX--;
            }
        }
        if (node.yCoord - tailY > 1) {
            if (node.xCoord - tailX > 0) {
                tailY++;
                tailX++;
            } else if (tailX - node.xCoord > 0) {
                tailY++;
                tailX--;
            } else {
                tailY++;
            }
        } else if (tailY - node.yCoord > 1) {
            if (tailX - node.xCoord > 0) {
                // move diagonal
                tailX--;
                tailY--;
            } else if (node.xCoord - tailX > 0) {
                tailX++;
                tailY--;
            } else {
                tailY--;
            }
        }
        String tailcoordinate = Integer.toString(tailX) + Integer.toString(tailY);
        // check if tail has been here before
        visited.add(new coordinate(tailX, tailY));
    }

    public void followTail(Tail node) {
        // check if Head has moved more than 1 unit
        if (node.tailX - tailX > 1) {
            if (node.tailY - tailY > 0) {
                // need to move diagonal
                tailX++;
                tailY++;
            } else if (tailY - node.tailY > 0) {
                tailX++;
                tailY--;
            } else {
                // move toward head
                tailX++;
            }
        } else if (tailX - node.tailX > 1) { // H is left of T
            if (tailY - node.tailY > 0) { // move diagonal
                tailX--;
                tailY--;
            } else if (node.tailY - tailY > 0) {
                tailX--;
                tailY++;
            } else {
                tailX--;
            }
        }
        if (node.tailY - tailY > 1) {
            if (node.tailX - tailX > 0) {
                tailY++;
                tailX++;
            } else if (tailX - node.tailX > 0) {
                tailY++;
                tailX--;
            } else {
                tailY++;
            }
        } else if (tailY - node.tailY > 1) {
            if (tailX - node.tailX > 0) {
                // move diagonal
                tailX--;
                tailY--;
            } else if (node.tailX - tailX > 0) {
                tailX++;
                tailY--;
            } else {
                tailY--;
            }
        }
        String tailcoordinate = Integer.toString(tailX) + Integer.toString(tailY);
        // check if tail has been here before
        // visited.add(tailcoordinate);
        visited.add(new coordinate(tailX, tailY));

    }

}
