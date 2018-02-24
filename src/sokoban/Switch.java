package sokoban;

public class Switch extends Cell {
    private SwitchableHole hole;


    public Switch(SwitchableHole h){
        hole = h;
    }


    @Override
    public void acceptEntity(Entity n, Directions dir, Owner o) {
        super.acceptEntity(n, dir, o);

        if (n.pressButton())
            hole.setOpen(true);
    }

    @Override
    public void removeEntity() {
        super.removeEntity();
        hole.setOpen(false);
    }
}
