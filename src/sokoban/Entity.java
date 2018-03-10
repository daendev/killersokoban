package sokoban;

public abstract class Entity {

    private Cell place;
    private Entity owner;
    private Warehouse warehouse;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Entity getOwner() {
        return owner;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public Cell getPlace() {
        return place;
    }

    public void setPlace(Cell place) {
        this.place = place;
    }

    public Entity() {
        place = new Cell();
    }

    Entity(Cell p)
    {
        place = p;
    }

    public boolean isMovable(Directions dir){
        return place.getNeighbour(dir).canMoveHere(dir);
    }

    public abstract void addScore(int amount);

    public void move(Directions dir, Entity owner){
        if (place.getNeighbour(dir).canMoveHere(dir))
            step(dir,owner);
    }

    public void step(Directions dir, Entity owner){
        place.getNeighbour(dir).acceptEntity(this, dir, owner);
        if (place != null)
        {
            place.removeEntity();
            place = place.getNeighbour(dir);
        }
    }

    public abstract boolean pressButton();

}
