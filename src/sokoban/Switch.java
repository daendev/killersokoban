package sokoban;

public class Switch extends Cell {
    private SwitchableHole hole;

    @Override
    public void acceptEntity(Entity n, Directions dir) {
        super.acceptEntity(n, dir);

        if (n.pressButton())
            hole.setOpen(true);
    }

    @Override
    public void removeEntity() {
        super.removeEntity();
        hole.setOpen(false);
    }
}
