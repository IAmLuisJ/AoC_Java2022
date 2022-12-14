import java.util.Objects;

public class coordinate {
    int x;
    int y;

    public coordinate(int tailX, int tailY) {
        x = tailX;
        y = tailY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        coordinate other = (coordinate) obj;
        return this.x == other.x && this.y == other.y;

    }

}
