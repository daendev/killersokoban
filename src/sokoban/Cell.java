package sokoban;

/**
 * A játékban a cellákat (játéktér mezői) megvalósító osztály.
 */
public class Cell {

    String name;

    /**
     * A cellával szomszédos cellák.
     */
    private Cell[] neighbours;

    /**
     * A cellán álló elem.
     * @see Entity
     * @see Player
     * @see Box
     */
    private Entity holding;

    /**
     * Az a raktár, amiben a cella van.
     * @see Warehouse
     */
    private Warehouse warehouse;

    /**
     * Létrehozza a cellát.
     * TESZTELÉS CÉLJÁRA
     */
    public Cell(){
        neighbours = new Cell[4];
    }

    public Cell(String name){
        neighbours = new Cell[4];
        this.name=name;
        Logger.createObject(this, name);
    }

    /**
     * Egy adott raktárban létrehozza a cellát.
     * @param w Az a raktár, amiben a cella lesz.
     */
    public Cell(Warehouse w){
        neighbours = new Cell[4];
        warehouse = w;
    }

    /**
     * Belehelyezi a cellát egy raktárba.
     * @param warehouse A raktár, ahol a cellának lennie kell.
     */
    public void setWarehouse(Warehouse warehouse) {
        Logger.begin(this, "setWarehouse");
        this.warehouse = warehouse;
        Logger.end(this, "setWarehouse", "void");
    }

    /**
     * Megadja, hogy melyik raktárban van a cella.
     * @return A cellát tartalmazó raktár.
     */
    public Warehouse getWarehouse() {
        Logger.begin(this, "getWarehouse");
        Logger.end(this, "getWarehouse", warehouse.toString());
        return warehouse;
    }

    /**
     * Megadja, hogy mi áll éppen a cellán.
     * @return A cella tartalma.
     * @see Entity
     */
    public Entity getHolding() {
        Logger.begin(this, "getHolding");
        Logger.end(this, "getHolding", holding.toString());
        return holding;
    }

    /**
     * Ráhelyez valamit a cellába.
     * @param holding Amit ráhelyez.
     * @see Entity
     */
    public void setHolding(Entity holding) {
        Logger.begin(this, "setHolding");
        this.holding = holding;
        Logger.end(this, "setHolding", "void");
    }

    /**
     * Egy adott irányban a cella szomszédját adja meg.
     * @param d Az irány, amire kíváncsiak vagyunk.
     * @return Az adott irányban lévő szomszéd.
     */
    public Cell getNeighbour(Directions d) {
        Logger.begin(this, "getNeighbour");
        Logger.end(this, "getNeighbour", neighbours[d.ordinal()].toString());
        return neighbours[d.ordinal()];
    }

    /**
     * Egy adott irányban beállítja, hogy ki legyen a szomszédja a cellának.
     * @param neighbour Aki a szomszéd lesz.
     * @param dir Amelyik irányban állítja be.
     */
    public void setNeighbour(Cell neighbour, Directions dir ) {
        Logger.begin(this, "setNeighbour");
        this.neighbours[dir.ordinal()] = neighbour;
        Logger.end(this, "setNeighbour", "void");
    }

    /**
     * Befogad valamit a cellára (tolás során) és ráhelyezi.
     * @param n Amit befogad.
     * @param dir Amelyik irányban tolódik a befogadott dolog.
     * @param mOwner Aki a tolást kezdeményezte, ezzel rátolva a cellára az új dolgot és letolva a régit.
     * @return Sikeresen befogadta-e az új dolgot.
     */
    public boolean acceptEntity(Entity n, Directions dir, Entity mOwner){
        Logger.begin(this, "acceptEntity");
        if(holding == null){
            holding = n;
            return true;
        } else if (holding.move(dir, mOwner)){
            holding = n;
            Logger.end(this, "acceptEntity", Boolean.toString(true));
            return true;
        }
        Logger.end(this, "acceptEntity", Boolean.toString(false));
        return false;
    }

    /**
     * Eltávolítja a cella tartalmát.
     */
    public void removeEntity(){
        Logger.begin(this, "removeEntity");
        holding = null;
        Logger.end(this, "removeEntity", "void");
    }
}
