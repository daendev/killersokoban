package sokoban;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A játékban a cellákat (játéktér mezői) megvalósító osztály.
 */
public class Cell {

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
     * Mennyire csúszós a cella.
     */
    private Stickyness sticky;

    /**
     * Létrehozza a cellát.
     * TESZTELÉS CÉLJÁRA
     */
    public Cell(){
        neighbours = new Cell[4];
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
        this.warehouse = warehouse;
    }

    /**
     * Megadja, hogy melyik raktárban van a cella.
     * @return A cellát tartalmazó raktár.
     */
    public Warehouse getWarehouse() {
        return warehouse;
    }

    /**
     * Megadja, hogy mi áll éppen a cellán.
     * @return A cella tartalma.
     * @see Entity
     */
    public Entity getHolding() {
        return holding;
    }

    /**
     * Ráhelyez valamit a cellába.
     * @param holding Amit ráhelyez.
     * @see Entity
     */
    public void setHolding(Entity holding) {
        this.holding = holding;
    }

    /**
     * Egy adott irányban a cella szomszédját adja meg.
     * @param d Az irány, amire kíváncsiak vagyunk.
     * @return Az adott irányban lévő szomszéd.
     */
    public Cell getNeighbour(Directions d) {
        return neighbours[d.ordinal()];
    }

    /**
     * Egy adott irányban beállítja, hogy ki legyen a szomszédja a cellának.
     * @param neighbour Aki a szomszéd lesz.
     * @param dir Amelyik irányban állítja be.
     */
    public void setNeighbour(Cell neighbour, Directions dir ) {
        this.neighbours[dir.ordinal()] = neighbour;
    }

    /**
     * Megadja, hogy mennyire csúszós a cella.
     * @return A cella csúszóssága.
     */
    public double getSticky() {
        return sticky.getValue();
    }

    /**
     * Beállítja a csúszósságát.
     * @param sticky Mennyire legyen csúszós a cella.
     */
    public void setSticky(Stickyness sticky) {
        this.sticky = sticky;
    }

    /**
     * Befogad valamit a cellára (tolás során) és ráhelyezi.
     * @param n Amit befogad.
     * @param dir Amelyik irányban tolódik a befogadott dolog.
     * @param mOwner Aki a tolást kezdeményezte, ezzel rátolva a cellára az új dolgot és letolva a régit.
     * @return Sikeresen befogadta-e az új dolgot.
     */
    public boolean acceptEntity(Entity n, Directions dir, Player mOwner, double weight){
        if(holding == null){
            holding = n;
            return true;
        } else if (holding.move(dir, mOwner, weight)){
            holding = n;
            return true;
        }
        return false;
    }

    /**
     * Eltávolítja a cella tartalmát.
     */
    public void removeEntity(){
        holding = null;
    }

    public int getX(){
        Cell cell = this;
        int ret = 0;
        while (cell.getNeighbour(Directions.left) != null){
            ret++;
            cell = cell.getNeighbour(Directions.left);
        }
        return ret;
    }
    public int getY(){
        Cell cell = this;
        int ret = 0;
        while (cell.getNeighbour(Directions.top) != null){
            ret++;
            cell = cell.getNeighbour(Directions.top);
        }
        return ret;
    }

    public void draw(){
        if (holding != null)
            holding.draw();
        else
            System.out.print("-");
    }

    public void draw(FileWriter f) throws IOException {
        if (holding != null)
            holding.draw(f);
        else
            f.write("-");
    }
}
