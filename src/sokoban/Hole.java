package sokoban;

public class Hole extends Cell {
    @Override
    public boolean acceptEntity(Entity n, Directions dir, Entity mOwner) {
        n.stepOnHole(mOwner);
        return true;
    }
}
