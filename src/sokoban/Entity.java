package sokoban;

public abstract class Entity {

    private Cell place;
    private Owner owner;
    private Warehouse warehouse;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
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

    public void move(Directions dir, Owner o){
        if (place.getNeighbour(dir).canMoveHere(dir))
            step(dir,o);
    }

    public void step(Directions dir, Owner o){
        place.getNeighbour(dir).acceptEntity(this, dir, o);
        if (place != null)
        {
            place.removeEntity();
            place = place.getNeighbour(dir);
        }
    }

    public abstract boolean pressButton();

}
