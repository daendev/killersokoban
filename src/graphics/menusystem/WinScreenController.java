package graphics.menusystem;

import graphics.SokobanApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class WinScreenController {

    @FXML
    Label wintext;

    public void setWinner(int index){
        wintext.setText("Player " + index + " wins.");
    }

    public void returnButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("main");
    }
}
