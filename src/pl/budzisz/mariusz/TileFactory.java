package pl.budzisz.mariusz;

import javafx.scene.layout.Pane;

import java.util.Random;

public class TileFactory {
    private static final Random rn = new Random();
    private int randomInt = rn.nextInt(4) + 2;
    public Tile getInstance(int x, int y, Pane pane){
        Tile tile = new Tile(x,y);
        if (tile.getTileId() % randomInt  == 0){
            tile.setHasBomb(true);
        }
        return tile;
    }
}
