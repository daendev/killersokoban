package sokoban;

public class Box extends Entity{

    public Box()
    {
        super();
        setOwner(Owner.none);
    }

    @Override
    public boolean pressButton() {
        return true;
    }
}
