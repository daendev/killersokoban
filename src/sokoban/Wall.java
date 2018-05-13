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

    /**
     * Lehet-e ide mozogni.
     * @param dir Az irány, amerre tesztelünk.
     * @param weight A tesztelési lánc össz súllya.
     * @param strength A tesztelési erő.
     * @return Lehet-e ide mozogni.
     */
    @Override
    public boolean canMoveHere(Directions dir, double weight, double strength) {
        Test.logger.w("Wall.canMoveHere(Directions, double");
        return false;
    }

    /**
     * Fájlba rajzolás.
     * @param f A kimeneti fájl.
     * @throws IOException
     */
    @Override
    public void draw(FileWriter f) throws IOException {
        Test.logger.w("Wall.draw(FileWriter)");
        f.write("W");
    }

    /**
     * Commandline-ra rajzolás.
     */
    @Override
    public void draw() {
        Test.logger.w("Wall.draw()");
        System.out.print("W");
    }

    /**
     * Fájlba rajzolás mentésre.
     * @param f A kimeneti fájl.
     * @throws IOException
     */
    @Override
    public void drawForSave(FileWriter f) throws IOException {
        Test.logger.w("Wall.drawForSave(FileWriter)");
        f.write("W");
    }

    //TODO JavaDoc
    /**
     *
     * @return
     */
    @Override
    public ObjectGraphics createGraphics() {
        return new WallGraphics(this);
    }
}
