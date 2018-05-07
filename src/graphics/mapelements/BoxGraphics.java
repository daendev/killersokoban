package graphics.mapelements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sokoban.Box;

public class BoxGraphics extends EntityGraphics {

    public BoxGraphics(Box b){
        super(b);
        z = 2;
        shape = new Rectangle();
        ((Rectangle) shape).setWidth(cellSize);
        ((Rectangle) shape).setHeight(cellSize);
        shape.setFill(Color.web("FF9800"));
    }

}
