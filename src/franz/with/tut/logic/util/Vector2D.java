package franz.with.tut.logic.util;

public class Vector2D {
    public int x;
    public int y;

    public Vector2D(int x, int y) {
        set(x, y);
    }

    public Vector2D() {
        set(-1, -1);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D vector2D) {
        set(vector2D.x, vector2D.y);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vector2D position && position.x == x && position.y == y;
    }
}
