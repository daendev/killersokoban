package sokoban;

/**
 * A játékban a kapcsolókat megvalósító osztály.
 * @see Cell
 */
public class Switch extends Cell {

    /**
     * Az a lyuk, amit a kapcsoló kapcsol.
     * @see SwitchableHole
     */
    private SwitchableHole hole;

    /**
     * Létrehozza a kapcsolót.
     * @param h Az a lyuk, amit kapcsolnia kell majd a kapcsolónak.
     */
    public Switch(SwitchableHole h){
        hole = h;
    }
    public Switch(String name, SwitchableHole h){
        hole = h;
        this.name = name;
    }

    /**
     * Befogad valamit a kapcsolóra (tolás során) és ráhelyezi.
     * @param n Amit befogad.
     * @param dir Amelyik irányban tolódik a befogadott dolog, tehát amerre a mostani tartalomnak is tolódnia kell.
     * @param mOwner Aki a tolást kezdeményezte, ezzel rátolva a kapcsolóra az új dolgot és letolva a régit.
     * @return Sikeresen befogadta-e.
     */
    @Override
    public boolean acceptEntity(Entity n, Directions dir, Entity mOwner) {
        Logger.begin(this, "acceptEntity");
        boolean succesful = super.acceptEntity(n, dir, mOwner);
        if(succesful)
            n.stepOnSwitch(hole, mOwner);
        Logger.end(this, "acceptEntity", Boolean.toString(succesful));
        return succesful;
    }

    /**
     * Leveszi a kapcsolóról a rajta álló dolgot.
     */
    @Override
    public void removeEntity() {
        Logger.begin(this, "removeEntity");
        super.removeEntity();
        hole.setOpen(false, null);
        Logger.end(this, "removeEntity", "void");
    }
}
