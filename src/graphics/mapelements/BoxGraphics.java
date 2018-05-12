package graphics.mapelements;

import graphics.menusystem.GameController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sokoban.Box;

public class BoxGraphics extends EntityGraphics {


    public BoxGraphics(Box b){
        super(b);
        z = 2;
        Rectangle r = new Rectangle();
        r.setWidth(GameController.cellSize);
        r.setHeight(GameController.cellSize);
        r.setFill(Color.web("FF9800"));
        graphics.getChildren().add(r);

    }

    @Override
    public boolean ping(){
        if(reference.getPlace() == null) return false;
        if(reference.getOwner()!=reference) ((Rectangle)graphics.getChildren().get(0)).setFill(Color.web("EF6C00"));
        graphics.relocate(transformCoords(reference.getPlace().getX()), transformCoords(reference.getPlace().getY()));
        return true;
    }

}
