package graphics.mapelements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sokoban.Cell;

public class CellGraphics extends ObjectGraphics {

    protected Cell reference;

    public CellGraphics(Cell c){
        reference = c;
        shape = new Rectangle();
        ((Rectangle) shape).setWidth(cellSize);
        ((Rectangle) shape).setHeight(cellSize);
        shape.setFill(Color.web("E0E0E0"));
    }

    public void update(){
        x = transformCoords(reference.getX());
        y = transformCoords(reference.getY());
    }
}
