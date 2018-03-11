package sokoban;

public class Switch extends Cell {
    private SwitchableHole hole;


    public Switch(SwitchableHole h){
        hole = h;
    }


    @Override
    public boolean acceptEntity(Entity n, Directions dir, Entity mOwner) {
        boolean succesful = super.acceptEntity(n, dir, mOwner);
        if(succesful)
            n.stepOnSwitch(hole, mOwner);
        return succesful;
    }

    @Override
    public void removeEntity() {
        super.removeEntity();
        hole.setOpen(false, null);
    }
}
