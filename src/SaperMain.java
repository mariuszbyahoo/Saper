import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SaperMain extends Application {
    private final int TILE_SIZE = 100;
    private final int BOARD_SIZE = 5;

    private Pane createPane (){
        Pane root = new Pane();
        root.setPrefSize(TILE_SIZE * BOARD_SIZE, TILE_SIZE * BOARD_SIZE);
        return root;
    }

    public static void main (String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(createPane());
        stage.setTitle("Saper 0.1");
        stage.setScene(scene);
        stage.show();
    }
}
