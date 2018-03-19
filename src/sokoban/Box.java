package sokoban;

/**
 * A játékban a dobozokat megvalósító osztály.
 * @see Entity
 */
public class Box extends Entity{
    /**
     * Létrehozza a dobozt.
     * Kezdetben a doboz tulajdonosa saját maga, mivel még senki nem tolta egy cél cellára.
     */
    public Box()
    {
        super();
        setOwner(this);
    }

    /**
     * A doboz arrébtolása.
     * @param dir A tolás iránya
     * @param mOwner Ki kezdeményezte a tolást
     * @return Sikeresen arrébb tolódott-e a doboz.
     */
    @Override
    public boolean move(Directions dir, Entity mOwner) {
        Logger.begin(this, "move");
        if(!getOwner().equals(this))
            return false;
        if (getPlace().getNeighbour(dir).acceptEntity(this, dir, mOwner)){
            getPlace().removeEntity();
            setPlace(getPlace().getNeighbour(dir));
            Logger.end(this, "move", Boolean.toString(true));
            return true;
        }
        Logger.end(this, "move", Boolean.toString(false));
        return false;
    }

    /**
     * A doboz célra tolódását kezeli.
     * Beállítja a tulajdonosát arra, aki betolta a célba, majd pontot ad neki.
     * @param mOwner Aki a tolást kezdeményezte, és így a helyére tolta.
     */
    @Override
    public void stepOnGoal(Entity mOwner) {
        Logger.begin(this, "stepOnGoal");
        setOwner(mOwner);
        mOwner.addScore(1);
        Logger.end(this, "stepOnGoal", "void");
    }

    /**
     * A doboz lyukra tolódását kezeli.
     * Ha lyukra tolják, leesik a doboz, ezzel lekerülve a pályáról.
     * @param mOwner Aki a tolást kezdeményezte, és ezzel lelökte.
     */
    @Override
    public void stepOnHole(Entity mOwner) {
        Logger.begin(this, "stepOnHole");
		getWarehouse().removeEntity(this);
        Logger.end(this, "stepOnHole", "void");
    }

    /**
     * A doboz kapcsolóra tolódását kezeli.
     * Ha kapcsolóra tolják, kinyitja a hozzá tartozó lyukat.
     * @param aSwitch Az a lyuk, amit ki kell nyitnia.
     * @param mOwner Aki a tolást kezdeményezte, ezzel kinyitva a lyukat.
     */
    @Override
    public void stepOnSwitch(SwitchableHole aSwitch, Entity mOwner) {
        Logger.begin(this, "stepOnSwitch");
        aSwitch.setOpen(true, mOwner);
        Logger.end(this, "stepOnSwitch", "void");
    }

    /**
     * Kompatibilitás céljából megvalósított függvény.
     * @see Entity
     * @see Player
     */
    @Override
    public void die() {
        Logger.begin(this, "die");
        Logger.end(this, "die", "void");

    }

    /**
     * Kompatibilitás céljából megvalósított függvény.
     * @see Entity
     * @see Player
     */
    @Override
    public void addScore(int amount){
        Logger.begin(this, "addScore");
        Logger.end(this, "addScore", "void");
    }
}
