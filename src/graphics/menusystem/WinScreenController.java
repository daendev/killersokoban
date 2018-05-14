package graphics.menusystem;

import graphics.SokobanApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class WinScreenController {

    /**
     * Nyertes játékos sorszámát kiíró szöveg.
     */
    @FXML
    Label wintext;

    /**
     * Beállítja a szöveget a nyertes játékos alapján.
     * @param index a nyertes játékos sorszáma.
     */
    public void setWinner(int index){
        if(index==-1) wintext.setText("It's a draw!");
        else wintext.setText("Player " + index + " wins.");
    }


    /**
     * Vissza a menübe gomb.
     * @param actionEvent a gombnyomás eseménye.
     */
    public void returnButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("main");
    }
}
