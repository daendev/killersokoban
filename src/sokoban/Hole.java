package sokoban;

public class Hole extends Cell {
    @Override
    public void acceptEntity(Entity n, Directions dir, Owner o) {
        //TODO ezt meg kell írni

        if (!n.pressButton())
        {
            if (!o.equals(n.getOwner()))
            {}
            //TODO pont a másiknak
        }
    }

    @Override
    public boolean canMoveHere(Directions dir) {
        return true;
    }
}
