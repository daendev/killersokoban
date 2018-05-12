package graphics.mapelements;

import graphics.menusystem.GameController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sokoban.Cell;

public class CellGraphics extends ObjectGraphics {

    protected Cell reference;

    public CellGraphics(Cell c){
        reference = c;
        z = 0;
        Rectangle r = new Rectangle();
        r.setWidth(GameController.cellSize);
        r.setHeight(GameController.cellSize);
        r.setFill(Color.web("E0E0E0"));
        graphics.getChildren().add(r);
    }

    public boolean ping(){
        graphics.relocate(transformCoords(reference.getX()), transformCoords(reference.getY()));
        return true;
    }

}
