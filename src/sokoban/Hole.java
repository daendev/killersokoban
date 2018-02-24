package sokoban;

public class Hole extends Cell {
    @Override
    public void acceptEntity(Entity n, Directions dir, Owner o) {
        if (!n.pressButton() && !o.equals(n.getOwner()))
            getWarehouse().addScore(o);
        getWarehouse().removeEntity(n);
    }

    @Override
    public boolean canMoveHere(Directions dir) {
        return true;
    }
}
