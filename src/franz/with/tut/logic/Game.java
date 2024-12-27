package franz.with.tut.logic;

import franz.with.tut.logic.forests.Forest;
import franz.with.tut.logic.path.finding.PathFinding;
import franz.with.tut.logic.tiles.Tile;
import franz.with.tut.ui.UI;
import java.util.Stack;

public class Game {
    private final Forest forest;

    public Game(Forest forest) {
        this.forest = forest;
    }

    public void play(UI ui) throws Exception {
        ui.showForest(forest);

        ui.showCalculatingPath();
        Stack<Tile> path = PathFinding.useAStar(forest.getKevinsTile(), forest.getCampTile(), forest, ui);

        while (!path.isEmpty()) {
            path.pop().stepOn();
            ui.showForest(forest);
        }
    }
}