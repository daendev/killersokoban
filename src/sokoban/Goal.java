package sokoban;

/**
 * A játékban a célhelyeket megvalósító osztály.
 * @see Cell
 */
public class Goal extends Cell{

    /**
     * Befogad valamit a cellára (tolás során) és ráhelyezi.
     * @param n Amit befogad.
     * @param dir Amelyik irányban tolódik a befogadott dolog, tehát amerre a mostani tartalomnak is tolódnia kell.
     * @param mOwner Aki a tolást kezdeményezte, ezzel rátolva a cellára az új dolgot és letolva a régit.
     * @return Sikeresen befogadta-e az új dolgot.
     */
    @Override
    public boolean acceptEntity(Entity n, Directions dir, Player mOwner, double weight) {
        if(super.acceptEntity(n, dir, mOwner, weight)) {
            n.stepOnGoal(mOwner);
            return true;
        }
        return false;
    }
}
