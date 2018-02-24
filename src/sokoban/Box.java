package sokoban;

public class Box extends Entity{

    public Box()
    {
        setOwner(Owner.none);
    }

    @Override
    public boolean pressButton() {
        return true;
    }
}
