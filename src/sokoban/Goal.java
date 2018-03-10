package sokoban;

public class Goal extends Cell{

    @Override
    public boolean acceptEntity(Entity n, Directions dir, Entity owner) {
        super.acceptEntity(n, dir, owner);

        if (n.pressButton())
        {
            n.setOwner(owner);
            owner.addScore(1);
        }
    }
}
