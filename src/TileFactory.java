import javafx.scene.layout.Pane;

public class TileFactory {
    public Tile getInstance(int x, int y, Pane pane){
        Tile tile = new Tile(x,y, pane);
        return tile;
    }
}
