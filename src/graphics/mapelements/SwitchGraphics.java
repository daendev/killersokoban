package graphics.mapelements;

import graphics.menusystem.GameController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sokoban.Switch;

import javax.sound.midi.Receiver;

/**
 * Kapcsoló grafika kezelése
 */
public class SwitchGraphics extends CellGraphics {

    /**
     * Kapcsoló grafika konstruktora
     * @param s A kapcsoló
     */
    public SwitchGraphics(Switch s){
        super(s);

        int cell = GameController.cellSize;

        Rectangle back = new Rectangle();
        back.setWidth(cell*0.8);
        back.setHeight(cell*0.8);
        back.setX(cell*0.2);
        back.setY(cell*0.2);
        back.setFill(Color.web("757575"));

        Rectangle top = new Rectangle();
        top.setWidth(cell*0.4);
        top.setHeight(cell*0.2);
        top.setX(cell*0.4);
        top.setY(cell*0.4);
        top.setFill(Color.web("CE93D8"));

        Rectangle bottom = new Rectangle();
        bottom.setWidth(cell*0.4);
        bottom.setHeight(cell*0.2);
        bottom.setX(cell*0.2);
        bottom.setY(cell*0.4);
        bottom.setFill(Color.web("AB47BC"));

        graphics.getChildren().addAll(back, top, bottom);
    }
}
