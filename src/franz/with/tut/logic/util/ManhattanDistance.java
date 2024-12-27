package franz.with.tut.logic.util;

public class ManhattanDistance {
    private ManhattanDistance() {
    }

    public static int calculate(Vector2D firstPosition, Vector2D secondPosition) {
        return Math.abs(firstPosition.x - secondPosition.x) + Math.abs(firstPosition.y - secondPosition.y);
    }
}