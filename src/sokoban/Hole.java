package sokoban;

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

    @Override
    public void draw(FileWriter f) throws IOException {
        Test.logger.w("Hole.draw(FileWriter)");
        f.write("H");
    }

    @Override
    public void draw(){
        Test.logger.w("Hole.draw()");
        System.out.print("H");
    }

    @Override
    public void drawForSave(FileWriter f) throws IOException {
        Test.logger.w("Hole.drawForSave(FileWriter)");
        f.write("H");
    }
}
