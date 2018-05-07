package graphics.menusystem;

import graphics.SokobanApp;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class MainMenuController {


    public void startButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("game");
    }

    public void settingsButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("settings");
    }

    public void exitButton(ActionEvent actionEvent) {
        Platform.exit();
    }
}
