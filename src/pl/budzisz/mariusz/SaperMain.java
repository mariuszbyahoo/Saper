package pl.budzisz.mariusz;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class SaperMain extends Application {

    public static final int TILE_SIZE = 100;
    public static final int BOARD_SIZE = 5;

    public static Pane pane;

    Group tileGroup = new Group();

    public static void main (String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        pane = new Pane();
        Scene scene = new Scene(pane);
        pane.setPrefSize(TILE_SIZE * BOARD_SIZE, TILE_SIZE * BOARD_SIZE);
        initBoard(tileGroup, pane);
        pane.getChildren().add(tileGroup);
        stage.setTitle("Saper 0.3");
        stage.setScene(scene);
        stage.show();
    }
    public void initBoard(Group tileGroup, Pane pane){
        TileFactory factory = new TileFactory();
        for (int x = 0; x < BOARD_SIZE; x ++){
            for (int y = 0 ; y < BOARD_SIZE ; y ++){
                tileGroup.getChildren().add(factory.getInstance(x,y, pane));
            }
        }
    }
}
