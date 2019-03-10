package pl.budzisz.mariusz;

import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;


public class Tile extends Rectangle {

    private boolean hasBomb = false;
    private boolean clickable = true;
    private int tileId;

    private static final AtomicInteger count = new AtomicInteger(0);


    public Tile (int x, int y){

        setWidth(SaperMain.TILE_SIZE);
        setHeight(SaperMain.TILE_SIZE);
        relocate(SaperMain.TILE_SIZE * x, SaperMain.TILE_SIZE * y);
        setFill(Color.ORANGE);
        setStroke(Color.RED);
        setStrokeWidth(0.5);
        this.setOnMouseClicked(e -> {
            if (clickable) {
                if (!hasBomb) {
                    this.setFill(Color.BEIGE);
                } else {
                    this.setFill(Color.RED);
                    jihad();
                    exit(SaperMain.pane);

                }
            }
        });
        tileId = count.incrementAndGet();
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
    public int getTileId(){
        return tileId;
    }

    public void setHasBomb(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    public void exit(Pane pane) {
        new Thread(new ExitingThread(pane)).start();
    }
}
