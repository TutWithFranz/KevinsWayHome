package franz.with.tut.logic.path.finding;

import franz.with.tut.logic.forests.Forest;
import franz.with.tut.logic.tiles.Tile;
import franz.with.tut.ui.UI;
import franz.with.tut.logic.util.ManhattanDistance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public final class PathFinding {
    private PathFinding() {
    }

    public static Stack<Tile> useAStar(Tile start, Tile end, Forest forest, UI ui) { // TODO remove ui
        ArrayList<Tile> possibleTiles = new ArrayList<>();
        HashSet<Tile> processedTiles = new HashSet<>();

        start.setGCost(0);
        start.setHCost(ManhattanDistance.calculate(start.getPosition(), end.getPosition()));
        possibleTiles.add(start);

        while (!possibleTiles.isEmpty()) {
            Tile currentTile = possibleTiles.get(0);
            // find best step
            for (Tile tile : possibleTiles) {
                if (tile.getFCost() < currentTile.getFCost() ||
                        tile.getFCost() == currentTile.getFCost() && tile.getHCost() < currentTile.getHCost()) {
                    currentTile = tile;
                }
            }

            possibleTiles.remove(currentTile);
            processedTiles.add(currentTile);

            // TODO remove
            currentTile.lookAt();
            ui.showForest(forest);
            // TODO remove

            if (currentTile.equals(end)) {
                Stack<Tile> path = new Stack<>();

                // back trace path
                while (!currentTile.equals(start)) {
                    path.add(currentTile);
                    currentTile = (Tile) currentTile.getPrevious();
                }

                return path;
            }

            // update neighbors
            for (Tile neighbor : forest.getNeighboringTiles(currentTile)) {
                if (neighbor.isPassable() && !processedTiles.contains(neighbor)) {

                    boolean isNotInPossibleTiles = !possibleTiles.contains(neighbor);
                    int neighborGCost = currentTile.getGCost() + 1;

                    if (isNotInPossibleTiles || neighborGCost < neighbor.getGCost()) {
                        // update neighbor g cost
                        neighbor.setPrevious(currentTile);
                        neighbor.setGCost(neighborGCost);

                        // add neighbor as new possible tile
                        if (isNotInPossibleTiles) {
                            neighbor.setHCost(ManhattanDistance.calculate(neighbor.getPosition(), end.getPosition()));
                            possibleTiles.add(neighbor);
                        }
                    }
                }
            }
        }

        return null;
    }
}