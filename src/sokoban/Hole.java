package sokoban;

import graphics.mapelements.HoleGraphics;
import graphics.mapelements.ObjectGraphics;
import test.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A játékban a lyukakat megvalósító osztály.
 * @see Cell
 */
public class Hole extends Cell {

    /**
     * Befogad valamit a lyukra. Ami ráérkezik, leesik.
     * @param n Amit befogad.
     * @param dir Amelyik irányban tolódik a befogadott dolog, tehát amerre a mostani tartalomnak is tolódnia kell.
     * @param mOwner Aki a tolást kezdeményezte, ezzel rátolva a lyukra az új dolgot és letolva a régit.
     * @return Sikeresen befogadta-e az új dolgot.
     */
    @Override
    public boolean acceptEntity(Entity n, Directions dir, Player mOwner, double weight) {
        Test.logger.w("Hole.acceptEntity(Entity, Directions, Player, weight)");
        n.stepOnHole(mOwner);
        return true;
    }

    /**
     * Lehet-e erre a mezőre mozogni.
     * @param dir Az irány, amerre tesztelünk.
     * @param weight A tesztelési lánc össz súllya.
     * @param strength A tesztelési erő.
     * @return Lehet-e ide mozogni. Mindig igaz, mert lyukba akármikor eshetünk.
     */
    @Override
    public boolean canMoveHere(Directions dir, double weight, double strength) {
        Test.logger.w("Hole.canMoveHere(Directions, weight, strength");
        return true;
    }

    /**
     * Fájlba rajzolás.
     * @param f A kimeneti fájl.
     * @throws IOException
     */
    @Override
    public void draw(FileWriter f) throws IOException {
        Test.logger.w("Hole.draw(FileWriter)");
        f.write("H");
    }

    /**
     * Commandline-ra rajzolás.
     */
    @Override
    public void draw(){
        Test.logger.w("Hole.draw()");
        System.out.print("H");
    }

    /**
     * Fájlba rajzolás mentésre.
     * @param f A kimeneti fájl.
     * @throws IOException
     */
    @Override
    public void drawForSave(FileWriter f) throws IOException {
        Test.logger.w("Hole.drawForSave(FileWriter)");
        f.write("H");
    }

    //TODO JavaDoc
    /**
     *
     * @return
     */
    @Override
    public ObjectGraphics createGraphics(){
        return new HoleGraphics(this);
    }
}
