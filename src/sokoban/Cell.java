package sokoban;

import test.Test;

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
        Test.logger.w("Cell.constructor()");
        neighbours = new Cell[4];
        sticky = Stickyness.Normal;
    }

    /**
     * Egy adott raktárban létrehozza a cellát.
     * @param w Az a raktár, amiben a cella lesz.
     */
    public Cell(Warehouse w){
        Test.logger.w("Cell.constructor(Warehouse)");
        neighbours = new Cell[4];
        warehouse = w;
    }

    /**
     * Belehelyezi a cellát egy raktárba.
     * @param warehouse A raktár, ahol a cellának lennie kell.
     */
    public void setWarehouse(Warehouse warehouse) {
        Test.logger.w("Cell.setWarehouse(Warehouse)");
        this.warehouse = warehouse;
    }

    /**
     * Megadja, hogy melyik raktárban van a cella.
     * @return A cellát tartalmazó raktár.
     */
    public Warehouse getWarehouse() {
        Test.logger.w("Cell.getWarehouse()");
        return warehouse;
    }

    /**
     * Megadja, hogy mi áll éppen a cellán.
     * @return A cella tartalma.
     * @see Entity
     */
    public Entity getHolding() {
        Test.logger.w("Cell.getHolding()");
        return holding;
    }

    /**
     * Ráhelyez valamit a cellába.
     * @param holding Amit ráhelyez.
     * @see Entity
     */
    public void setHolding(Entity holding) {
        Test.logger.w("Cell.setHolding()");
        this.holding = holding;
    }

    /**
     * Egy adott irányban a cella szomszédját adja meg.
     * @param d Az irány, amire kíváncsiak vagyunk.
     * @return Az adott irányban lévő szomszéd.
     */
    public Cell getNeighbour(Directions d) {
        Test.logger.w("Cell.getNeighbour(Direction)");
        return neighbours[d.ordinal()];
    }

    /**
     * Egy adott irányban beállítja, hogy ki legyen a szomszédja a cellának.
     * @param neighbour Aki a szomszéd lesz.
     * @param dir Amelyik irányban állítja be.
     */
    public void setNeighbour(Cell neighbour, Directions dir ) {
        Test.logger.w("Cell.setNeighbour(Cell, Direction)");
        this.neighbours[dir.ordinal()] = neighbour;
    }

    /**
     * Megadja, hogy mennyire csúszós a cella.
     * @return A cella csúszóssága.
     */
    public double getSticky() {
        Test.logger.w("Cell.getSticky()");
        return sticky.getValue();
    }

    /**
     * Beállítja a csúszósságát.
     * @param sticky Mennyire legyen csúszós a cella.
     */
    public void setSticky(Stickyness sticky) {
        Test.logger.w("Cell.setSticky(Stickyness)");
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
        Test.logger.w("Cell.acceptEntity(Entity, Directions, Player, double)");
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
        Test.logger.w("Cell.removeEntity()");
        holding = null;
    }

    public int getX(){
        Test.logger.w("Cell.getX()");
        Cell cell = this;
        int ret = 0;
        while (cell.getNeighbour(Directions.left) != null){
            ret++;
            cell = cell.getNeighbour(Directions.left);
        }
        return ret;
    }
    public int getY(){
        Test.logger.w("Cell.getY()");
        Cell cell = this;
        int ret = 0;
        while (cell.getNeighbour(Directions.top) != null){
            ret++;
            cell = cell.getNeighbour(Directions.top);
        }
        return ret;
    }

    public void draw(){
        Test.logger.w("Cell.draw()");
        if (holding != null)
            holding.draw();
        else
            System.out.print("-");
    }

    public void draw(FileWriter f) throws IOException {
        Test.logger.w("Cell.draw(FileWriter)");
        if (holding != null)
            holding.draw(f);
        else
            f.write("-");
    }
}
