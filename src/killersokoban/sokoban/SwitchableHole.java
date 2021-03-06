package killersokoban.sokoban;

import killersokoban.graphics.mapelements.ObjectGraphics;
import killersokoban.graphics.mapelements.SwitchableHoleGraphics;
import killersokoban.test.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A játékban a kapcsolható lyukakat megvalósító osztály.
 * @see Hole
 */
public class SwitchableHole extends Hole{

    /**
     * A kapcsolható lyuk állapota. Ha igaz nyitva van, ha hamis, zárva.
     */
    private boolean open;

    /**
     * Beállítja a kapcsolható lyuk állapotát.
     * @param open Mi legyen a kapcsolható lyuk állapota. Ha igaz, nyitott, ha hamis, zárt.
     * @param mOwner Aki beállíttott a kapcsoló állapotát.
     */
    public void setOpen(boolean open, Entity mOwner) {
        Test.logger.w("SwitchabelHole.setOpen(boolean, Entity)");
        this.open = open;
        if (open && getHolding() != null){
            getHolding().stepOnHole(mOwner);
        }
    }

    /**
     * Befogad valamit a lyukra. Ami ráérkezik, leesik, ha a lyuk nyitva van.
     * @param n Amit befogad.
     * @param dir Amelyik irányban tolódik a befogadott dolog, tehát amerre a mostani tartalomnak is tolódnia kell.
     * @param mOwner Aki a tolást kezdeményezte, ezzel rátolva a lyukra az új dolgot és letolva a régit.
     * @return Sikeresen befogadta-e az új dolgot.
     */
    @Override
    public boolean acceptEntity(Entity n, Directions dir, Player mOwner, double weight) {
        Test.logger.w("SwitchabelHole.acceptEntity(Entity, Directions, Player, double");
        if (open) {
            return super.acceptEntity(n, dir, mOwner, weight);
        } else {
            if(getHolding() == null){
                setHolding(n);
                return true;
            } else if (getHolding().move(dir, mOwner, weight)){
                setHolding(n);
                return true;
            }
            return false;
        }
    }

    /**
     * Lehet-e ide mozogni.
     * @param dir Az irány, amerre tesztelünk.
     * @param weight A tesztelési lánc össz súllya.
     * @param strength A tesztelési erő.
     * @return Lehet-e ide mozogni.
     */
    @Override
    public boolean canMoveHere(Directions dir, double weight, double strength) {
        if(open) {
            return super.canMoveHere(dir, weight, strength);
        } else if(getHolding() == null) {
            return true;
        } else {
            return getHolding().canMove(dir, weight, strength);
        }
    }

    /**
     * Commandline-ra rajzolás.
     */
    @Override
    public void draw() {
        Test.logger.w("SwitchabelHole.draw()");
        if (open)
            System.out.print("H");
        else if (getHolding() != null)
            getHolding().draw();
        else
            System.out.print("-");
    }

    /**
     * Fájlba rajzolás.
     * @param f A kimeneti fájl.
     * @throws IOException
     */
    public void draw(FileWriter f) throws IOException {
        Test.logger.w("SwitchabelHole.draw(FileWriter");
        if (open)
            f.write("H");
        else if (getHolding() != null)
            getHolding().draw(f);
        else
            f.write("-");
    }

    /**
     * Fájlba rajzolás mentésre.
     * @param f A kimeneti fájl.
     * @throws IOException
     */
    @Override
    public void drawForSave(FileWriter f) throws IOException {
        Test.logger.w("SwitchabelHole.drawForSave(FileWriter");
        if (open)
            f.write("H");
        else
            f.write("-");
    }

    public boolean isOpen(){
        return open;
    }

    //TODO JavaDoc
    /**
     *
     * @return
     */
    @Override
    public ObjectGraphics createGraphics(){
        return new SwitchableHoleGraphics(this);
    }
}
