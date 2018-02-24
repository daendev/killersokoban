package sokoban;

public abstract class Entity {

    private Cell place;

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

    public void move(Directions dir){
        if (place.getNeighbour(dir).canMoveHere(dir))
            step(dir);
    }

    public void step(Directions dir){
        place.getNeighbour(dir).acceptEntity(this, dir);
        place.removeEntity();
        place = place.getNeighbour(dir);
    }

    public abstract boolean pressButton();

}
