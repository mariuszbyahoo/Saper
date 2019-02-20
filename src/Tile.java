import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;


public class Tile extends Rectangle {

    private boolean hasBomb = false;
    // boolean clickable stands for making the rest of application stucked when explodes.
    private boolean clickable = true;

    Random rn = new Random();

    public Tile (int x, int y, Pane root){
        setWidth(SaperMain.TILE_SIZE);
        setHeight(SaperMain.TILE_SIZE);
        relocate(SaperMain.TILE_SIZE * x, SaperMain.TILE_SIZE * y);
        setFill(Color.ORANGE);
        setStroke(Color.RED);
        setStrokeWidth(0.5);
        if (x == rn.nextInt(SaperMain.BOARD_SIZE - 1) && y == rn.nextInt(SaperMain.BOARD_SIZE - 1)) {
            this.hasBomb = true;
        }
        this.setOnMouseClicked(e -> {
            if (clickable) {
                if (!hasBomb) {
                    this.setFill(Color.BEIGE);
                    // deleting the commentary slashes below will make the game playable and put the bombs in a few places.
                } else {
                    jihad();
                    this.setFill(Color.RED);
                }
            }
        });
    }
    private void jihad () {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ALLAHU AKHBAAAR");
        alert.setContentText("Game over");
        alert.show();
        String uriString = new File("allahu-akbar-sound-effect-download-link-BMA0XO7C.mp3").toURI().toString();
        MediaPlayer player = new MediaPlayer( new Media(uriString));
        player.play();
    }
}
