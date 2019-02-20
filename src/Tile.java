import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Tile extends Rectangle {

    public Tile ( int x, int y){
        setWidth(SaperMain.TILE_SIZE);
        setHeight(SaperMain.TILE_SIZE);
        relocate(SaperMain.TILE_SIZE * x, SaperMain.TILE_SIZE * y);
        setFill(Color.ORANGE);
        setStroke(Color.RED);
        setStrokeWidth(0.5);
        this.setOnMouseClicked(e -> {
                    this.setFill(Color.BEIGE);
                }
                );
    }
}
