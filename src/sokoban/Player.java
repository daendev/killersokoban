package sokoban;

public class Player extends Entity{

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player(Owner o){
        score = 0;
        setOwner(o);
    }

    @Override
    public boolean pressButton() {
        return false;
    }

    @Override
    public boolean isMovable(Directions dir) {
        return true;
    }

    @Override
    public void step(Directions dir, Owner o) {
        if (getPlace().getNeighbour(dir).canMoveHere(dir))
            super.step(dir, o);
        else {}//TODO meghalás
    }
}
