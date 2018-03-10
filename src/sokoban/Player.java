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
    public void stepOnGoal(Entity mOwner) {

    }

    public void die(){
        getPlace().setHolding(null);
        setPlace(null);
    }

    @Override
    public void stepOnHole(Entity mOwner) {
        if(!mOwner.equals(this))
            mOwner.addScore(1);
    }

    @Override
    public void stepOnSwitch(SwitchableHole aSwitch) {

    }
}
