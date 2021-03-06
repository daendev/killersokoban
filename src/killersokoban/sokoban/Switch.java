package killersokoban.sokoban;

import killersokoban.graphics.mapelements.ObjectGraphics;
import killersokoban.graphics.mapelements.SwitchGraphics;
import killersokoban.test.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A játékban a kapcsolókat megvalósító osztály.
 * @see Cell
 */
public class Switch extends Cell {

    /**
     * Az a lyuk, amit a kapcsoló kapcsol.
     * @see SwitchableHole
     */
    private SwitchableHole hole;

    /**
     * Létrehozza a kapcsolót.
     * @param h Az a lyuk, amit kapcsolnia kell majd a kapcsolónak.
     */
    public Switch(SwitchableHole h){
        Test.logger.w("Switch()");
        hole = h;
    }

    /**
     * Befogad valamit a kapcsolóra (tolás során) és ráhelyezi.
     * @param n Amit befogad.
     * @param dir Amelyik irányban tolódik a befogadott dolog, tehát amerre a mostani tartalomnak is tolódnia kell.
     * @param mOwner Aki a tolást kezdeményezte, ezzel rátolva a kapcsolóra az új dolgot és letolva a régit.
     * @return Sikeresen befogadta-e.
     */
    @Override
    public boolean acceptEntity(Entity n, Directions dir, Player mOwner, double weight) {
        Test.logger.w("Switch.acceptEntity(Entity, Directions, Player, double)");
        boolean succesful = super.acceptEntity(n, dir, mOwner, weight);
        if(succesful)
            n.stepOnSwitch(hole, mOwner);
        return succesful;
    }

    /**
     * Leveszi a kapcsolóról a rajta álló dolgot.
     */
    @Override
    public void removeEntity() {
        Test.logger.w("Switch.removeEntity()");
        super.removeEntity();
        hole.setOpen(false, null);
    }

    /**
     * Commandline-ra rajzolás.
     */
    @Override
    public void draw() {
        Test.logger.w("Switch.draw()");
        if (getHolding() != null)
            getHolding().draw();
        else
            System.out.print("S");
    }

    /**
     * Fájlba rajzolás
     * @param f A kimeneti fájl.
     * @throws IOException
     */
    public void draw(FileWriter f) throws IOException {
        Test.logger.w("Switch.draw(FileWriter");
        if (getHolding() != null)
            getHolding().draw();
        else
            f.write("S");
    }

    /**
     * Fájlba rajzolás mentésre.
     * @param f A kimeneti fájl.
     * @throws IOException
     */
    @Override
    public void drawForSave(FileWriter f) throws IOException {
        Test.logger.w("Switch.drawForSave(FileWriter");
        f.write("S");
    }

    /**
     * Vissza adja a kapcsolóhoz tartozó lyukat.
     * @return A kapcsolóhoz tartozó lyuk.
     */
    public SwitchableHole getHole()
    {
        Test.logger.w("Switch.getHole()");
        return hole;
    }

    /**
     * Beállítja a kapcsolóhoz tartozó lyukat.
     * @param hole A lyuk
     */
    public void setHole(SwitchableHole hole)
    {
        Test.logger.w("Switch.setHole(SwitchableHole");
        this.hole = hole;
    }

    //TODO JavaDoc
    /**
     *
     * @return
     */
    @Override
    public ObjectGraphics createGraphics(){
        return new SwitchGraphics(this);
    }
}
