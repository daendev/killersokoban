package killersokoban.graphics.mapelements;

import killersokoban.graphics.menusystem.GameController;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import killersokoban.sokoban.Cell;

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
        if(reference.getSticky()<1) drawSticky(Color.web("212121"));
        if(reference.getSticky()>1) drawSticky(Color.web("FFFF00"));
    }

    /**
     * @return pályán van e az adott elem, vagy már nem
     * Updateli a grafikát.
     */
    public boolean ping(){
        graphics.relocate(transformCoords(reference.getX()), transformCoords(reference.getY()));
        return true;
    }

    /**
     * Ragacsot rajzol a pályára.
     * @param color a ragacs színe.
     */
    private void drawSticky(Paint color){
        int cell = GameController.cellSize;
        Circle c1 = new Circle();
        c1.setRadius(cell*0.3);
        c1.setFill(color);
        c1.relocate(cell*0.4,cell*0.4);
        Circle c2 = new Circle();
        c2.setRadius(cell*0.3);
        c2.setFill(color);
        c2.relocate(cell*0.6,cell*0.5);
        Circle c3 = new Circle();
        c3.setRadius(cell*0.3);
        c3.setFill(color);
        c3.relocate(cell*0.4,cell*0.6);
        graphics.getChildren().addAll(c1,c2,c3);
    }

}
