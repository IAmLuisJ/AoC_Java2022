
public class Head {
    // Class Object for grid
    int xCoord = 0;
    int yCoord = 0;

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public void MoveHead(String direction) {
        if (direction.equals("U")) {
            // move up
            setyCoord(yCoord + 1);
        }
        if (direction.equals("R")) {
            setxCoord(xCoord + 1);
        }
        if (direction.equals("D")) {
            setyCoord(yCoord - 1);
        }
        if (direction.equals("L")) {
            setxCoord(xCoord - 1);
        }

    }

}