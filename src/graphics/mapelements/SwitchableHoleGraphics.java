package graphics.mapelements;

import javafx.scene.Group;
import sokoban.Cell;
import sokoban.Hole;
import sokoban.SwitchableHole;

/**
 * Kapcsolható lyuk grafikai kezelése
 */
public class SwitchableHoleGraphics extends HoleGraphics {

    Group openGraphics;
    Group closedGraphics;

    /**
     * Kapcsolható lyuk grafika konstruktora
     * @param s A kapcsolható lyuk
     */
    public SwitchableHoleGraphics(SwitchableHole s){
        super(s);
    }

    public boolean ping(){
        if(((SwitchableHole)reference).isOpen()) {
            graphics = new HoleGraphics(new Hole()).getGraphics();
            z = 3;
        }
        else {
            graphics = new CellGraphics(new Cell()).getGraphics();
            z = 0;
        }
        graphics.relocate(transformCoords(reference.getX()), transformCoords(reference.getY()));
        return true;
    }
}
