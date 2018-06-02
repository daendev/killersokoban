package killersokoban.graphics.mapelements;

import killersokoban.sokoban.Cell;
import killersokoban.sokoban.Hole;
import killersokoban.sokoban.SwitchableHole;

/**
 * Kapcsolható lyuk grafikai kezelése
 */
public class SwitchableHoleGraphics extends HoleGraphics {

    /**
     * Kapcsolható lyuk grafika konstruktora
     * @param s A kapcsolható lyuk
     */
    public SwitchableHoleGraphics(SwitchableHole s){
        super(s);
    }

    /**
     * Modell lekérdezése és grafika frissítése.
     * @return igaz, ha az objektumot még ki kell rajzolni.
     */
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
