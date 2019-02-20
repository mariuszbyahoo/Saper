import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SaperMain extends Application {
    public static final int TILE_SIZE = 100;
    private final int BOARD_SIZE = 5;

    Group tileGroup = new Group();

    public static void main (String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root);
        root.setPrefSize(TILE_SIZE * BOARD_SIZE, TILE_SIZE * BOARD_SIZE);
        initBoard(tileGroup);
        root.getChildren().add(tileGroup);
        stage.setTitle("Saper 0.1");
        stage.setScene(scene);
        stage.show();
    }

    public void initBoard(Group tileGroup){
        TileFactory factory = new TileFactory();
        for (int x = 0; x < BOARD_SIZE; x ++){
            for (int y = 0 ; y < BOARD_SIZE ; y ++){
                tileGroup.getChildren().add(factory.getInstance(x,y));
            }
        }
    }
}
