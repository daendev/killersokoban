package graphics.mapelements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sokoban.Wall;

public class WallGraphics extends CellGraphics {


    public WallGraphics(Wall c) {
        super(c);
        shape.setFill(Color.web("757575"));
    }
}
