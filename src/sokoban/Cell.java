package sokoban;

public class Cell {


    private Cell[] neighbours;

    private Entity holding;

    private Warehouse warehouse;

    public Cell(){
        neighbours = new Cell[4];
    }

    public Cell(Warehouse w){
        neighbours = new Cell[4];
        warehouse = w;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Entity getHolding() {
        return holding;
    }

    public void setHolding(Entity holding) {
        this.holding = holding;
    }

    public Cell getNeighbour(Directions d) {
        return neighbours[d.ordinal()];
    }

    public void setNeighbour(Cell neighbour, Directions dir ) {
        this.neighbours[dir.ordinal()] = neighbour;
    }

    public boolean acceptEntity(Entity n, Directions dir, Entity owner){
        if(holding == null){
            holding = n;
            return true;
        } else if (holding.move(dir, owner)){
            holding = n;
            return true;
        }
        return false;

    }

    public void removeEntity(){
        holding = null;
    }
}
