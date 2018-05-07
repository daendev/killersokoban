package graphics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class SokobanApp extends Application {

    private static HashMap<String, Scene> scenes = new HashMap<>();
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;

        Scene mainMenu = new Scene(FXMLLoader.load(getClass().getResource("menusystem/mainmenu.fxml")), 500, 600);
        Scene settingsMenu = new Scene(FXMLLoader.load(getClass().getResource("menusystem/settingsmenu.fxml")), 500, 600);
        Scene game = new Scene(FXMLLoader.load(getClass().getResource("menusystem/game.fxml")), 500, 600);

        scenes.put("main", mainMenu);
        scenes.put("settings", settingsMenu);
        scenes.put("game", game);

        stage.setScene(mainMenu);
        stage.setTitle("Killer Sokoban");
        stage.show();
    }

    public static void switchScenes(String s){
        stage.setScene(scenes.get(s));
    }

    public static void main(String[] args){
        launch(args);
    }
}
