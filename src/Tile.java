import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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
                } else {
                    System.out.println("To wybuchło");
                    Pane jihadPane = new AnchorPane();
                    Stage jihadStage = new Stage();
                    jihadStage.setTitle("Jihad");
                    Scene jihadScene = new Scene(jihadPane);
                    jihadStage.setScene(jihadScene);
                    jihadStage.show();
                    this.setFill(Color.RED);
                    // Code bellow contains some issue... Plays no video.
                    String source = "https://www.youtube.com/watch?v=-H0QHwz21-g";
                    Media media = new Media(source);
                    MediaPlayer mediaPlayer = new MediaPlayer(media);
                    mediaPlayer.play();
                    MediaView mediaView = new MediaView(mediaPlayer);
                    jihadPane.getChildren().add(mediaView);
                }
            }
        });
    }
}
