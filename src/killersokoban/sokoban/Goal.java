package killersokoban.sokoban;
import killersokoban.graphics.mapelements.GoalGraphics;
import killersokoban.graphics.mapelements.ObjectGraphics;
import killersokoban.test.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A játékban a célhelyeket megvalósító osztály.
 * @see Cell
 */
public class Goal extends Cell {

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

    /**
     * Lehet-e az adott mezőre mozogni. A játék befejezésének tesztelésére.
     * @param dir Az irány, amerre tesztelünk.
     * @param weight A tesztelési lánc össz súllya.
     * @param strength A tesztelési erő.
     * @return Lehet-e erre a mezőre mozogni.
     */
    @Override
    public boolean canMoveHere(Directions dir, double weight, double strength) {
        Test.logger.w("Goal.canMoveHere(Directions, weight, strength");
        if(getHolding() != null) {
            if (getHolding().getOwner() == getHolding()) {
                return super.canMoveHere(dir, weight, strength);
            }
            return false;
        }
        return true;
    }

    /**
     * Commandline-ra rajzolás.
     */
    @Override
    public void draw(){
        Test.logger.w("Goal.draw()");
        if(getHolding()!=null)
            getHolding().draw();
        else System.out.print("G");
    }

    /**
     * Fájlba rajzolás.
     * @param f A kimeneti fájl.
     * @throws IOException
     */
    @Override
    public void draw(FileWriter f) throws IOException {
        Test.logger.w("Goal.draw(FileWriter)");
        if(getHolding()!=null)
            getHolding().draw();
        else f.write("G");
    }

    /**
     * Fájlba rajzolás mentésre
     * @param f A kimeneti fájl.
     * @throws IOException
     */
    @Override
    public void drawForSave(FileWriter f) throws IOException {
        Test.logger.w("Goal.drawForSave(FileWriter)");
        f.write("G");
    }

    //TODO JavaDoc
    /**
     *
     * @return
     */
    @Override
    public ObjectGraphics createGraphics(){
        return new GoalGraphics(this);
    }
}
