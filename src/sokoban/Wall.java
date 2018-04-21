package sokoban;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A játékban a cellákat (játéktér mezői) megvalósító osztály.
 * @see Cell
 */
public class Wall extends Cell {

    /**
     * Befogad valamit a falra. A falakon nem állhat semmi, így sose fogadja be.
     * @param n Amit befogad.
     * @param dir Amelyik irányban tolódik a befogadott dolog.
     * @param mOwner Aki a tolást kezdeményezte.
     * @return Sikeresen befogadta-e az új dolgot.
     */
    @Override
    public boolean acceptEntity(Entity n, Directions dir, Player mOwner, double weight) {
        return false;
    }


    @Override
    public void draw(FileWriter f) throws IOException {
        f.write("W");
    }

    @Override
    public void draw() {
        System.out.print("W");
    }
}
