package sokoban;

public class Goal extends Cell{
    @Override
    public boolean canMoveHere(Directions dir) {
        if (getHolding().pressButton())
            return false;
        return super.canMoveHere(dir);
    }
}
