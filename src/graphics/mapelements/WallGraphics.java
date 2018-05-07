package graphics.mapelements;

import javafx.scene.paint.Color;
import sokoban.Wall;

public class WallGraphics extends CellGraphics {


    public WallGraphics(Wall c) {
        super(c);
        z = 2;
        shape.setFill(Color.web("757575"));
    }
}
