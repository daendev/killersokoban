package sokoban;

public class SwitchableHole extends Hole{
    private boolean open;

    public void setOpen(boolean open) {
        this.open = open;
        if (open)
            getWarehouse().removeEntity(getHolding());
    }

    @Override
    public boolean acceptEntity(Entity n, Directions dir, Entity mOwner) {
        if (open) {
            return super.acceptEntity(n, dir, mOwner);
        } else {
            if(getHolding() == null){
                setHolding(n);
                return true;
            } else if (getHolding().move(dir, mOwner)){
                setHolding(n);
                return true;
            }
            return false;
        }

    }
}