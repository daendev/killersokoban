package sokoban;

public class Goal extends Cell{

    @Override
    public boolean acceptEntity(Entity n, Directions dir, Entity mOwner) {
        if(super.acceptEntity(n, dir, mOwner)) {
            n.stepOnGoal(mOwner);
            return true;
        }
        return false;
    }
}
