package sokoban;

public class Entity {

    private Cell place;


    public Entity() {
    }

    Entity(Cell p)
    {
        place = p;
    }

    public boolean isMovable(Cell.Directions dir){
        return place.getNeighbour(dir).canMoveHere(dir);
    }

}
