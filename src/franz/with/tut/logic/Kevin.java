package franz.with.tut.logic;

import franz.with.tut.logic.util.Vector2D;

public class Kevin implements GameObject {
    private final Vector2D position;

    public Kevin(int x, int y) {
        this.position = new Vector2D(x, y);
    }

    @Override
    public String getSprite() {
        return "🤓";
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }
}
