package graphics.mapelements;

import graphics.menusystem.GameController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import sokoban.Player;

/**
 * A játékos grafikai kezelése
 */
public class PlayerGraphics extends EntityGraphics {

    /**
     * Játékos megjelenítésének mérete
     */
    private static int radius;

    /**
     * Játékos száma
     */
    public static int playerCount = 1;

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
        c.setFill(Color.web(chooseColor()));
        ++playerCount;
        graphics.getChildren().add(c);
    }

    /**
     * Játékos színének megadása
     * @return A szín ami a játékos legyen
     */
    private String chooseColor(){
        switch(playerCount){
            case 1: return "2196F3";
            case 2: return "F44336";
            case 3: return "4CAF50";
            case 4: return "FFEB3B";
        }
        return "9C27B0"; // default lila csak ugy random xd
    }

}
