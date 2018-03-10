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

    @Override
    public boolean move(Directions dir, Entity owner) {
        if(!owner.equals(this))
            return false;
        return super.move(dir, owner);
    }
}
