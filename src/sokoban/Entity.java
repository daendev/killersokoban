package sokoban;

public class Entity {

    private Cell place;


    public Entity() {
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
        place = place.getNeighbour(dir);
    }

}
