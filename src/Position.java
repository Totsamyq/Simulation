import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) return true;
        if (other == null || !(other instanceof Position)) return false;
        Position otherPosition = (Position) other;
        if (this.x == otherPosition.x && this.y == otherPosition.y) return true;
        return false;
    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
        public String toString(){

        return  "(" + x + ", " + y + ")";
    }
}
