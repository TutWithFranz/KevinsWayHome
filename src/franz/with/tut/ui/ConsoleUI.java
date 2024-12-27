package franz.with.tut.ui;

import franz.with.tut.logic.forests.Forest;

public class ConsoleUI implements UI {

    @Override
    public void showForest(Forest forest) {
        String[][] map = forest.as2DStringArray();

        StringBuilder output = new StringBuilder();

        // add x-coordinate
        output.append("\n ");
        for (int x = 0; x < map[0].length; x++) {
            output.append("  ").append(x + 1);
        }
        output.append('\n');

        for (int y = 0; y < map.length; y++) {
            // add y-coordinate
            output.append(y + 1);

            for (int x = 0; x < map[0].length; x++) {
                output.append(' ').append(map[y][x]);
            }

            // next line
            output.append('\n');
        }

        System.out.print(output);
    }

    @Override
    public void showCalculatingPath() {
        System.out.print("\nCalculating path...\n");
    }
}
