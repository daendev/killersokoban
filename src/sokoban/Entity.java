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

    }

}
