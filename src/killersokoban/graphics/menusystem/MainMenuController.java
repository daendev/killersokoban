package killersokoban.graphics.menusystem;

import killersokoban.SokobanApp;
import javafx.application.Platform;
import javafx.event.ActionEvent;

/**
 * A főmenü gombjainak kezelőosztálya.
 */
public class MainMenuController {


    /**
     * @param actionEvent Start event.
     * A Start gomb megnyomásának kezelése.
     */
    public void startButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("newgame");
    }

    /**
     * @param actionEvent Setting event.
     * A settings gomb nyomásának kezelése.
     */
    public void settingsButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("settings");
    }

    /**
     * @param actionEvent Exit event.
     * A kilépés gomb megnyomásának kezelése.
     */
    public void exitButton(ActionEvent actionEvent) {
        Platform.exit();
    }

    /**
     * @param actionEvent Load event.
     * A betöltés gomb megnyomásának kezelése.
     */
    public void loadButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("loadgame");
    }
}
