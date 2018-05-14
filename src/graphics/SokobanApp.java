package graphics;

import graphics.menusystem.GameController;
import graphics.menusystem.WinScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class SokobanApp extends Application {

    private static HashMap<String, Scene> scenes = new HashMap<>();
    private static Stage stage;
    private static FXMLLoader gameLoader, winLoader;

    /**
     * A JavaFX alkalmazás belépési pontja.
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;

        Scene mainMenu = new Scene(FXMLLoader.load(getClass().getResource("menusystem/mainmenu.fxml")), 500, 600);
        Scene settingsMenu = new Scene(FXMLLoader.load(getClass().getResource("menusystem/settingsmenu.fxml")), 500, 600);
        // Scene game = new Scene(FXMLLoader.load(getClass().getResource("menusystem/game.fxml")), 500, 600);

        gameLoader = new FXMLLoader(getClass().getResource("menusystem/game.fxml"));
        Scene game = new Scene(gameLoader.load());
        winLoader = new FXMLLoader(getClass().getResource("menusystem/winscreen.fxml"));
        Scene win = new Scene(winLoader.load());


        mainMenu.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        settingsMenu.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        game.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        win.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        scenes.put("main", mainMenu);
        scenes.put("settings", settingsMenu);
        scenes.put("game", game);
        scenes.put("win", win);

        game.setOnKeyPressed(e -> {
            gameLoader.<GameController>getController().handleKeyPress(e);
        });

        stage.setScene(mainMenu);
        stage.setTitle("Killer Sokoban");
        stage.show();
    }

    /**
     * Nézetek (menük) közötti váltás.
     * @param s a nézet (menü) neve.
     */
    public static void switchScenes(String s){
        if(s.equals("newgame")) {
            gameLoader.<GameController>getController().newGame();
            stage.setScene(scenes.get("game"));
        }
        else if(s.equals("loadgame")){
            gameLoader.<GameController>getController().loadGame();
            stage.setScene(scenes.get("game"));
        } else {
            stage.setScene(scenes.get(s));
        }
    }

    /**
     * Játék vége menü előhívása.
     * @param i a nyertes játékos sorszáma.
     */
    public static void win(int i){
        winLoader.<WinScreenController>getController().setWinner(i);
        stage.setScene(scenes.get("win"));
    }

    public static void main(String[] args){
        launch(args);
    }
}
