package sokoban;

public class Hole extends Cell {
    @Override
    public void acceptEntity(Entity n, Directions dir, Owner o) {
        //TODO ezt meg kell írni
    }

    @Override
    public boolean canMoveHere(Directions dir) {
        return true;
    }
}
