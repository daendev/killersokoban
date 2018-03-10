package sokoban;

public class Player extends Entity{

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player(){
        super();
        score = 0;
        setOwner(this);
    }

    public void addScore(int amount){
        score+=amount;
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
    public void step(Directions dir, Entity owner) {
        if (getPlace().getNeighbour(dir).canMoveHere(dir))
            super.step(dir, owner);
        else
        {
            owner.addScore(1);
            getPlace().getWarehouse().removeEntity(this);
        }
    }

    public void die(){
        getPlace().setHolding(null);
        setPlace(null);
    }
}
