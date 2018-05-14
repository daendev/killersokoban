package graphics.mapelements;

import graphics.menusystem.GameController;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import sokoban.Box;
import sokoban.Player;

/**
 * A dobozok grafikájának kezelése.
 */
public class BoxGraphics extends EntityGraphics {


    /**
     * @param b a doboz amit rajzolni kell
     * Doboz kirajzolása
     */
    public BoxGraphics(Box b){
        super(b);
        z = 2;
        Rectangle r = new Rectangle();
        r.setWidth(GameController.cellSize);
        r.setHeight(GameController.cellSize);
        r.setFill(Color.web("FF9800"));
        graphics.getChildren().add(r);

    }

    /**
     * @return pályán van e az adott elem, vagy már nem
     * Updateli a grafikát.
     */
    @Override
    public boolean ping(){
        if(reference.getPlace() == null) return false;
        if(reference.getOwner()!=reference) ((Rectangle)graphics.getChildren().get(0)).setFill(chooseColor((Player)reference.getOwner()));
        graphics.relocate(transformCoords(reference.getPlace().getX()), transformCoords(reference.getPlace().getY()));
        return true;
    }

    private Paint chooseColor(Player p){
        switch(p.getWarehouse().getPlayers().indexOf(p)){
            case 0:
                return Color.web("0D47A1");
            case 1:
                return Color.web("b71c1c");
            case 2:
                return Color.web("1B5E20");
            case 3:
                return Color.web("FFD600");
            default:
                return Color.web("F9A825");
        }
    }

}
