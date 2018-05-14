package graphics.mapelements;

import graphics.menusystem.GameController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import sokoban.Player;
import sokoban.Warehouse;

import java.util.ArrayList;

/**
 * A játékos grafikai kezelése
 */
public class PlayerGraphics extends EntityGraphics {

    /**
     * Játékos megjelenítésének mérete
     */
    private static int radius;


    /**
     * Játékos grafika konstruktora
     * @param p A játékos
     */
    public PlayerGraphics(Player p) {
        super(p);
        z = 1;
        radius = GameController.cellSize / 2;
        Circle c = new Circle();
        c.setRadius(radius);
        Warehouse w = reference.getWarehouse();
        ArrayList<Player> l = (ArrayList<Player>) w.getPlayers();
        int i = l.indexOf(reference);
        c.setFill(Color.web(chooseColor(reference.getWarehouse().getPlayers().indexOf(reference))));
        graphics.getChildren().add(c);
    }

    /**
     * Játékos színének megadása
     * @return A szín ami a játékos legyen
     */
    private String chooseColor(int playerIndex){
        switch(playerIndex){
            case 0: return "2196F3";
            case 1: return "F44336";
            case 2: return "4CAF50";
            case 3: return "FFEB3B";
        }
        return "9C27B0"; // default lila csak ugy random xd
    }

}
