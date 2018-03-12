package sokoban;

public class SwitchableHole extends Hole{
    private boolean open;

    public void setOpen(boolean open, Entity mOwner) {
        this.open = open;
        if (open && holding != null){
            getHolding().stepOnHole(mOwner);
        }
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
