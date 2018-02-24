package sokoban;

public class Hole extends Cell {
    @Override
    public void acceptEntity(Entity n, Directions dir) {

    }

    @Override
    public boolean canMoveHere(Directions dir) {
        return true;
    }
}
