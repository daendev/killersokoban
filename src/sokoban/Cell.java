package sokoban;

public class Cell {


    private Cell[] neighbours;

    private Entity holding;


    public Cell(){
        neighbours = new Cell[4];
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

    public void acceptEntity(Entity n, Directions dir, Owner o){
        if (holding != null)
            holding.step(dir,o);
        holding = n;
    }

    public void removeEntity(){
        holding = null;
    }

    public boolean canMoveHere(Directions dir){
        if (holding == null)
            return true;
        return holding.isMovable(dir);
    }
}
