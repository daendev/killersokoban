package sokoban;

/**
 * A játékban a cellákat (játéktér mezői) megvalósító osztály.
 * @see Cell
 */
public class Wall extends Cell {

    public Wall(String name){
        super(name);
    }

    /**
     * Befogad valamit a falra. A falakon nem állhat semmi, így sose fogadja be.
     * @param n Amit befogad.
     * @param dir Amelyik irányban tolódik a befogadott dolog.
     * @param mOwner Aki a tolást kezdeményezte.
     * @return Sikeresen befogadta-e az új dolgot.
     */
    @Override
    public boolean acceptEntity(Entity n, Directions dir, Entity mOwner) {
        Logger.begin(this, "acceptEntity");
        Logger.end(this, "acceptEntity", Boolean.toString(false));
        return false;
    }
}
