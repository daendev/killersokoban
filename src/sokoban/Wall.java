package sokoban;

import graphics.mapelements.ObjectGraphics;
import graphics.mapelements.WallGraphics;
import test.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A játékban a cellákat (játéktér mezői) megvalósító osztály.
 * @see Cell
 */
public class Wall extends Cell{

    /**
     * Befogad valamit a falra. A falakon nem állhat semmi, így sose fogadja be.
     * @param n Amit befogad.
     * @param dir Amelyik irányban tolódik a befogadott dolog.
     * @param mOwner Aki a tolást kezdeményezte.
     * @return Sikeresen befogadta-e az új dolgot.
     */
    @Override
    public boolean acceptEntity(Entity n, Directions dir, Player mOwner, double weight) {
        Test.logger.w("Wall.acceptEntity(Entity, Directions, Player, double)");
        return false;
    }

    @Override
    public boolean canMoveHere(Directions dir, double weight, double strength) {
        Test.logger.w("Wall.canMoveHere(Directions, double");
        return false;
    }

    @Override
    public void draw(FileWriter f) throws IOException {
        Test.logger.w("Wall.draw(FileWriter)");
        f.write("W");
    }

    @Override
    public void draw() {
        Test.logger.w("Wall.draw()");
        System.out.print("W");
    }

    @Override
    public void drawForSave(FileWriter f) throws IOException {
        Test.logger.w("Wall.drawForSave(FileWriter)");
        f.write("W");
    }

    @Override
    public ObjectGraphics createGraphics() {
        return new WallGraphics(this);
    }
}
