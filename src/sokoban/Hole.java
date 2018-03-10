package sokoban;

public class Hole extends Cell {
    @Override
    public void acceptEntity(Entity n, Directions dir, Entity owner) {
        if (!n.pressButton() && !owner.equals(n.getOwner()))
            owner.addScore(1);
        getWarehouse().removeEntity(n);
    }

    @Override
    public boolean canMoveHere(Directions dir) {
        return true;
    }
}
