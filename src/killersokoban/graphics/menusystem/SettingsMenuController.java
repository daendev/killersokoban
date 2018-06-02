package killersokoban.graphics.menusystem;

import killersokoban.graphics.SettingsData;
import killersokoban.SokobanApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


/**
 * A beállitások menü gombjainak kezelése.
 */
public class SettingsMenuController {

    @FXML
    private TextField width;

    @FXML
    private TextField height;

    @FXML
    private TextField players;

    /**
     * JavaFX controller inicializálás.
     */
    public void initialize(){
        SettingsData settings = new SettingsData(10,10,10);
        settings.read("settings.xml");
        width.setText(Integer.toString(settings.getWidth()));
        height.setText(Integer.toString(settings.getHeight()));
        players.setText(Integer.toString(settings.getPlayerCount()));
    }

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
        int w = Integer.parseInt(width.getText());
        int h = Integer.parseInt(height.getText());
        int p = Integer.parseInt(players.getText());
        SettingsData settings = new SettingsData(w,h,p);
        settings.write("settings.xml");
    }
}
