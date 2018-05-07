package graphics.mapelements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import sokoban.Player;

public class PlayerGraphics extends EntityGraphics {

    public static final int radius = 25;

    public PlayerGraphics(Player p) {
        super(p);
        shape = new Circle();
        ((Circle) shape).setRadius(radius);
        shape.setFill(Color.web("2196F3"));
    }

}
