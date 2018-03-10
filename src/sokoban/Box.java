package sokoban;

public class Box extends Entity{

    public Box()
    {
        super();
        setOwner(this);
    }

    public void addScore(int amount){}

    @Override
    public boolean pressButton() {
        return true;
    }
}
