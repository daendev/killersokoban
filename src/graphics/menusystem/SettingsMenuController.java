package graphics.menusystem;

import graphics.SokobanApp;
import javafx.event.ActionEvent;

public class SettingsMenuController {

    public void backButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("main");
    }
}
