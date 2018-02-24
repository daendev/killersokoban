package sokoban;

/**
 * 
 */

public class Cell {
    private boolean passable;
    private Entity holding;

    public Cell(){
        passable = true;
        holding = new Entity();
    }

    public boolean isPassable() {
        return passable;
    }

    public Entity getHolding() {
        return holding;
    }

    public void setPassable(boolean passable) {
        this.passable = passable;
    }

    public void setHolding(Entity holding) {
        this.holding = holding;
    }

    public void acceptEntity(Entity n){

    }
}
