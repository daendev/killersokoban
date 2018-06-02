package killersokoban.graphics.mapelements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import killersokoban.sokoban.Wall;

/**
 * Fal grafika kezelése
 */
public class WallGraphics extends CellGraphics {

    /**
     * Fal grafikai konstruktor
     * @param c A fal
     */
    public WallGraphics(Wall c) {
        super(c);
        z = 2;
        ((Rectangle)graphics.getChildren().get(0)).setFill(Color.web("757575"));
    }
}
