package sokoban;

public class Box extends Entity{

    public Box()
    {
        super();
        setOwner(this);
    }

    public void addScore(int amount){}

    @Override
    public boolean move(Directions dir, Entity owner) {
        if(!owner.equals(this))
            return false;
        return super.move(dir, owner);
    }

    @Override
    public void stepOnGoal(Entity mOwner) {
        setOwner(mOwner);
    }

    @Override
    public void stepOnHole(Entity mOwner) {

    }
    @Override
    public void die() {

    }

    @Override
    public void stepOnSwitch(SwitchableHole aSwitch, Entity mOwner) {
        aSwitch.setOpen(true, mOwner);
    }
}
