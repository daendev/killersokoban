package graphics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class SokobanApp extends Application {

    private HashMap<String, Scene> scenes = new HashMap<>();
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;
        Scene mainMenu = new Scene(FXMLLoader.load(getClass().getResource("mainmenu.fxml")), 500, 500);
        Scene settingsMenu = new Scene(FXMLLoader.load(getClass().getResource("settingsmenu.fxml")), 500, 500);
        Scene game = new Scene(FXMLLoader.load(getClass().getResource("game.fxml")), 500, 500);

        scenes.put("main", mainMenu);
        scenes.put("settings", settingsMenu);
        scenes.put("game", game);

        stage.setScene(mainMenu);
        stage.setTitle("Killer Sokoban");
        stage.show();
    }

    public void switchScenes(String s){
        stage.setScene(scenes.get(s));
    }

    public static void main(String[] args){
        launch(args);
    }
}
