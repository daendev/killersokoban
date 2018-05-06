package graphics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        stage.setScene(new Scene(new Game(), 500, 500));
        stage.setTitle("Killer Sokoban");
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
