package franz.with.tut.logic.tiles;

import franz.with.tut.logic.GameObject;
import franz.with.tut.logic.path.finding.Node;
import franz.with.tut.logic.util.Vector2D;

public abstract class Tile extends Node implements GameObject {
    private final Vector2D position;
    private final boolean isPassable;
    private String sprite;

    public Tile(int x, int y, boolean isPassable, String sprite) {
        position = new Vector2D(x, y);
        this.isPassable = isPassable;
        this.sprite = sprite;
    }

    public void stepOn() {
        sprite = "👣";
    }

    // TODO remove
    public void lookAt() {
        sprite = "👁️";
    }
    // TODO remove

    // getter

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Tile && ((Tile) obj).getPosition().equals(this.position);
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }

    @Override
    public String getSprite() {
        return sprite;
    }

    public boolean isPassable() {
        return isPassable;
    }
}