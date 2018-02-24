package sokoban;

public class SwitchableHole extends Hole{
    private boolean open;

    public void setOpen(boolean open) {
        this.open = open;
        //if (open)
        //    getWarehouse().removeEntity(getHolding());
    }

    @Override
    public void acceptEntity(Entity n, Directions dir, Owner o) {
        if (getHolding() != null)
            getHolding().step(dir, o);
        setHolding(n);


        if (open) {
            n.setPlace(this);
            super.acceptEntity(n, dir, o);
        }

    }

    @Override
    public boolean canMoveHere(Directions dir) {
        if (open) return true;
        if (getHolding() == null)
            return true;
        return getHolding().isMovable(dir);
    }
}
