package franz.with.tut.control;

import franz.with.tut.logic.Game;
import franz.with.tut.logic.forests.TestForest1;
import franz.with.tut.logic.forests.TestForest2;
import franz.with.tut.logic.forests.TestForest3;
import franz.with.tut.ui.ConsoleUI;
import franz.with.tut.ui.UI;

public class KevinsWayHome {
    public static void main(String[] args) {
        UI ui = new ConsoleUI();
        Game game = new Game(new TestForest2());
        try {
            game.play(ui);
        } catch (Exception e) {
            System.out.print(e.getLocalizedMessage());
        }
    }
}
