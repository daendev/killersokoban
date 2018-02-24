package sokoban;

public class Goal extends Cell{

    @Override
    public void acceptEntity(Entity n, Directions dir, Owner o) {
        super.acceptEntity(n, dir, o);

        if (n.pressButton())
        {
            n.setOwner(o);
            getWarehouse().addScore(o);

        }
    }

    @Override
    public boolean canMoveHere(Directions dir) {
        if (getHolding().pressButton())
            return false;
        return super.canMoveHere(dir);
    }
}
