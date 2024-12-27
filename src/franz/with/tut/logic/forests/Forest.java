package franz.with.tut.logic.forests;

import franz.with.tut.logic.Kevin;
import franz.with.tut.logic.tiles.Tile;
import franz.with.tut.logic.util.Vector2D;

import java.util.Arrays;
import java.util.HashSet;

public abstract class Forest {
    private final HashSet<Tile> tiles;
    private final Vector2D campPosition;
    private final Kevin kevin;
    private final Vector2D dimensions;
    private final Vector2D position;

    public Forest(Tile[] tiles, Vector2D dimensions, Vector2D campPosition, Kevin kevin) {
        this.tiles = new HashSet<>(Arrays.asList(tiles));
        this.campPosition = campPosition;
        this.kevin = kevin;
        this.dimensions = dimensions;
        this.position = new Vector2D();
    }

    public Tile getTile(Vector2D position) {
        for (Tile tile : tiles) {
            if (tile.getPosition().equals(position)) {
                return tile;
            }
        }

        return null;
    }

    public Tile getCampTile() {
        return getTile(campPosition);
    }

    public Tile getKevinsTile() {
        return getTile(kevin.getPosition());
    }

    public int getWidth() {
        return dimensions.x;
    }

    public int getHeight() {
        return dimensions.y;
    }

    public HashSet<Tile> getNeighboringTiles(Tile tile) {
        HashSet<Tile> result = new HashSet<>();
        Tile neighbor;
        if ((neighbor = getTile(tile.getPosition().x + 1, tile.getPosition().y)) != null) {
            result.add(neighbor);
        }
        if ((neighbor = getTile(tile.getPosition().x - 1, tile.getPosition().y)) != null) {
            result.add(neighbor);
        }
        if ((neighbor = getTile(tile.getPosition().x, tile.getPosition().y + 1)) != null) {
            result.add(neighbor);
        }
        if ((neighbor = getTile(tile.getPosition().x, tile.getPosition().y - 1)) != null) {
            result.add(neighbor);
        }

        return result;
    }

    private Tile getTile(int x, int y) {
        position.set(x, y);
        return getTile(position);
    }

    public String[][] as2DStringArray() {
        Vector2D position = new Vector2D();
        String[][] map = new String[getHeight()][getWidth()];

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getHeight(); x++) {
                position.set(x, y);
                map[y][x] = getTile(position).getSprite();
            }
        }

        map[kevin.getPosition().y][kevin.getPosition().x] = kevin.getSprite();
        return map;
    }
}
