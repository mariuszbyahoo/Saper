import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;


public class Tile extends Rectangle {

    private boolean hasBomb = false;
    private boolean clickable = true;

    Random rn = new Random();

    public Tile (int x, int y, Pane root){
        setWidth(SaperMain.TILE_SIZE);
        setHeight(SaperMain.TILE_SIZE);
        relocate(SaperMain.TILE_SIZE * x, SaperMain.TILE_SIZE * y);
        setFill(Color.ORANGE);
        setStroke(Color.RED);
        setStrokeWidth(0.5);
        if (x == rn.nextInt(SaperMain.BOARD_SIZE) && y == rn.nextInt(SaperMain.BOARD_SIZE)) {
            this.hasBomb = true;
        }
        this.setOnMouseClicked(e -> {
            if (clickable) {
                if (!hasBomb) {
                    this.setFill(Color.BEIGE);
                } else {
                    System.out.println("To wybuchło");
                    this.setFill(Color.RED);
                    jihad(root);
                }
            }
        });
    }
    private void jihad(Pane root){
        Media media = new Media("https://www.youtube.com/watch?v=-H0QHwz21-g");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        MediaView mediaView = new MediaView(mediaPlayer);

        root.getChildren().add(mediaView);
    }
}
