package sokoban;

/**
 * A játékban a kapcsolható lyukakat megvalósító osztály.
 * @see Hole
 */
public class SwitchableHole extends Hole{

    /**
     * A kapcsolható lyuk állapota. Ha igaz nyitva van, ha hamis, zárva.
     */
    private boolean open;

    /**
     * Beállítja a kapcsolható lyuk állapotát.
     * @param open Mi legyen a kapcsolható lyuk állapota. Ha igaz, nyitott, ha hamis, zárt.
     * @param mOwner Aki beállíttott a kapcsoló állapotát.
     */
    public void setOpen(boolean open, Entity mOwner) {
        this.open = open;
        if (open && getHolding() != null){
            getHolding().stepOnHole(mOwner);
        }
    }

    /**
     * Befogad valamit a lyukra. Ami ráérkezik, leesik, ha a lyuk nyitva van.
     * @param n Amit befogad.
     * @param dir Amelyik irányban tolódik a befogadott dolog, tehát amerre a mostani tartalomnak is tolódnia kell.
     * @param mOwner Aki a tolást kezdeményezte, ezzel rátolva a lyukra az új dolgot és letolva a régit.
     * @return Sikeresen befogadta-e az új dolgot.
     */
    @Override
    public boolean acceptEntity(Entity n, Directions dir, Entity mOwner) {
        if (open) {
            return super.acceptEntity(n, dir, mOwner);
        } else {
            if(getHolding() == null){
                setHolding(n);
                return true;
            } else if (getHolding().move(dir, mOwner)){
                setHolding(n);
                return true;
            }
            return false;
        }

    }
}
