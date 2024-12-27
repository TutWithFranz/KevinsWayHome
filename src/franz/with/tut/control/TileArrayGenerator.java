package franz.with.tut.control;

public class TileArrayGenerator {
    public static void main(String[] args) {
        int width = 4;
        int height = 4;

        System.out.print("new Tile[] { ");
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.format("new PlainTile(%d, %d), ", x, y);
            }
        }
        System.out.print("}");
        System.out.format(", new Vector2D(%d, %d)", width, height);
    }
}
