package graphics.menusystem;

import graphics.SettingsData;
import graphics.SokobanApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class SettingsMenuController {

    @FXML
    private TextField width;

    @FXML
    private TextField height;

    @FXML
    private TextField players;

    public void initialize(){
        SettingsData settings = new SettingsData(10,10,10);
        settings.read("settings.xml");
        width.setText(Integer.toString(settings.getWidth()));
        height.setText(Integer.toString(settings.getHeight()));
        players.setText(Integer.toString(settings.getPlayerCount()));
    }

    public void backButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("main");
    }

    public void saveButton(ActionEvent actionEvent) {
        int w = Integer.parseInt(width.getText());
        int h = Integer.parseInt(height.getText());
        int p = Integer.parseInt(players.getText());
        SettingsData settings = new SettingsData(w,h,p);
        settings.write("settings.xml");
    }
}
