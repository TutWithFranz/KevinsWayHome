package franz.with.tut.logic.forests;

import franz.with.tut.logic.Kevin;
import franz.with.tut.logic.tiles.CampTile;
import franz.with.tut.logic.tiles.PlainTile;
import franz.with.tut.logic.tiles.Tile;
import franz.with.tut.logic.tiles.TreeTile;
import franz.with.tut.logic.util.Vector2D;

public class TestForest3 extends Forest {

    public TestForest3() {
        super(new Tile[] { new PlainTile(0, 0), new PlainTile(1, 0), new PlainTile(2, 0), new PlainTile(3, 0),
                        new PlainTile(0, 1), new PlainTile(1, 1), new PlainTile(2, 1), new PlainTile(3, 1),
                        new PlainTile(0, 2), new PlainTile(1, 2), new TreeTile(2, 2), new PlainTile(3, 2),
                        new PlainTile(0, 3), new PlainTile(1, 3), new PlainTile(2, 3), new CampTile(3, 3), }
                , new Vector2D(4, 4), new Vector2D(3, 3), new Kevin(0, 0));
    }
}
