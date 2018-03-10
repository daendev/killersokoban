package sokoban;

public class Goal extends Cell{

    @Override
    public void acceptEntity(Entity n, Directions dir, Entity owner) {
        super.acceptEntity(n, dir, owner);

        if (n.pressButton())
        {
            n.setOwner(owner);
            owner.addScore(1);

        }
    }

    @Override
    public boolean canMoveHere(Directions dir) {
        if (getHolding().pressButton())
            return false;
        return super.canMoveHere(dir);
    }
}
