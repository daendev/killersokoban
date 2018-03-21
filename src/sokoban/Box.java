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
    public boolean move(Directions dir, Player mOwner, double weight) {
        if (weight + getFriction() >= mOwner.getStrenght()) {
            if (!getOwner().equals(this))
                return false;
            if (getPlace().getNeighbour(dir).acceptEntity(this, dir, mOwner, getFriction() + weight)) {
                getPlace().removeEntity();
                setPlace(getPlace().getNeighbour(dir));
                return true;
            }
        }
        return false;
    }

    /**
     * A doboz célra tolódását kezeli.
     * Beállítja a tulajdonosát arra, aki betolta a célba, majd pontot ad neki.
     * @param mOwner Aki a tolást kezdeményezte, és így a helyére tolta.
     */
    @Override
    public void stepOnGoal(Entity mOwner) {
        setOwner(mOwner);
        mOwner.addScore(1);
    }

    /**
     * A doboz lyukra tolódását kezeli.
     * Ha lyukra tolják, leesik a doboz, ezzel lekerülve a pályáról.
     * @param mOwner Aki a tolást kezdeményezte, és ezzel lelökte.
     */
    @Override
    public void stepOnHole(Entity mOwner) {
		getWarehouse().removeEntity(this);
    }

    /**
     * A doboz kapcsolóra tolódását kezeli.
     * Ha kapcsolóra tolják, kinyitja a hozzá tartozó lyukat.
     * @param aSwitch Az a lyuk, amit ki kell nyitnia.
     * @param mOwner Aki a tolást kezdeményezte, ezzel kinyitva a lyukat.
     */
    @Override
    public void stepOnSwitch(SwitchableHole aSwitch, Entity mOwner) {
        aSwitch.setOpen(true, mOwner);
    }

    /**
     * Kompatibilitás céljából megvalósított függvény.
     * @see Entity
     * @see Player
     */
    @Override
    public void die() {

    }

    /**
     * Kompatibilitás céljából megvalósított függvény.
     * @see Entity
     * @see Player
     */
    @Override
    public void addScore(int amount){

    }

    @Override
    public void draw() {
        System.out.print("B");
    }
}
