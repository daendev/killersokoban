package graphics.mapelements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sokoban.Wall;

public class WallGraphics extends CellGraphics {


    public WallGraphics(Wall c) {
        super(c);
        z = 2;
        ((Rectangle)graphics.getChildren().get(0)).setFill(Color.web("757575"));
    }
}
