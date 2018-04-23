package sokoban;
import test.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A játékban a célhelyeket megvalósító osztály.
 * @see Cell
 */
public class Goal extends Cell{

    /**
     * Befogad valamit a cellára (tolás során) és ráhelyezi.
     * @param n Amit befogad.
     * @param dir Amelyik irányban tolódik a befogadott dolog, tehát amerre a mostani tartalomnak is tolódnia kell.
     * @param mOwner Aki a tolást kezdeményezte, ezzel rátolva a cellára az új dolgot és letolva a régit.
     * @return Sikeresen befogadta-e az új dolgot.
     */
    @Override
    public boolean acceptEntity(Entity n, Directions dir, Player mOwner, double weight) {
        Test.logger.w("Goal.acceptEntity(Entity, Directions, Player, double)");
        if(super.acceptEntity(n, dir, mOwner, weight)) {
            n.stepOnGoal(mOwner);
            return true;
        }
        return false;
    }

    @Override
    public void draw(){
        Test.logger.w("Goal.draw()");
        if(getHolding()!=null)
            getHolding().draw();
        else System.out.print("G");
    }

    @Override
    public void draw(FileWriter f) throws IOException {
        Test.logger.w("Goal.draw(FileWriter)");
        if(getHolding()!=null)
            getHolding().draw();
        else f.write("G");
    }

    @Override
    public void drawForSave(FileWriter f) throws IOException {
        Test.logger.w("Goal.drawForSave(FileWriter)");
        f.write("G");
    }
}
