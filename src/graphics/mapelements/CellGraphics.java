package graphics.mapelements;

import graphics.menusystem.GameController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sokoban.Cell;

/**
 * A cellák grafikájának kezelése.
 */
public class CellGraphics extends ObjectGraphics {

    /**
     * A cella aminek a rajzolását kezeli.
     */
    protected Cell reference;

    /**
     * @param c A cella amit rajzolunk.
     * Kirajzolja a megadott cellát.
     */
    public CellGraphics(Cell c){
        reference = c;
        z = 0;
        Rectangle r = new Rectangle();
        r.setWidth(GameController.cellSize);
        r.setHeight(GameController.cellSize);
        r.setFill(Color.web("E0E0E0"));
        graphics.getChildren().add(r);
    }

    /**
     * @return
     */
    public boolean ping(){
        graphics.relocate(transformCoords(reference.getX()), transformCoords(reference.getY()));
        return true;
    }

}
