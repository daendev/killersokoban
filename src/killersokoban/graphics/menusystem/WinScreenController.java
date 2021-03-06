package killersokoban.graphics.menusystem;

import killersokoban.SokobanApp;
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
        if(index==0) wintext.setText("It's a draw!");
        else wintext.setText(new StringBuilder().append("Player ").append(index).append(" wins.").toString());
    }


    /**
     * Vissza a menübe gomb.
     * @param actionEvent a gombnyomás eseménye.
     */
    public void returnButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("main");
    }
}
