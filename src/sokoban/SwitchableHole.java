package sokoban;

public class SwitchableHole extends Hole{
    private boolean open;

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public void acceptEntity(Entity n, Directions dir, Owner o) {
        if (open) super.acceptEntity(n, dir, o);
        else {
            if (getHolding() != null)
                getHolding().step(dir, o);
            setHolding(n);
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
