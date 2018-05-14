package graphics.menusystem;

import graphics.SokobanApp;
import javafx.event.ActionEvent;

/**
 * A beállitások menü gombjainak kezelése.
 */
public class SettingsMenuController {

    /**
     * @param actionEvent Back event.
     * A vissza gomb megnyomásának kezelése.
     */
    public void backButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("main");
    }

    /**
     * @param actionEvent Save event.
     * A mentés gomb megnyomásának kezelése.
     */
    public void saveButton(ActionEvent actionEvent) {
    }
}
