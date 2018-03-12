package sokoban;

public class Box extends Entity{

    public Box()
    {
        super();
        setOwner(this);
        System.out.println("Box constructor");
    }

    public void addScore(int amount){

    }

    @Override
    public boolean move(Directions dir, Entity mOwner) {
        if(!getOwner().equals(this))
            return false;
        if (getPlace().getNeighbour(dir).acceptEntity(this, dir, mOwner)){
            getPlace().removeEntity();
            setPlace(getPlace().getNeighbour(dir));
            return true;
        }
        return false;
    }

    @Override
    public void stepOnGoal(Entity mOwner) {
        setOwner(mOwner);
        mOwner.addScore(1);
    }

    @Override
    public void stepOnHole(Entity mOwner) {
		getWarehouse().removeEntiy(this);
    }
    @Override
    public void die() {

    }

    @Override
    public void stepOnSwitch(SwitchableHole aSwitch, Entity mOwner) {
        aSwitch.setOpen(true, mOwner);
    }
}
