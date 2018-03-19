package sokoban;

/**
 * A játékban a játékosokat megvalósító osztály.
 * @see Entity
 */
public class Player extends Entity{

    /**
     * A játékos pontszáma.
     */
    private int score;

    /**
     * Létrehozza a játékost. Kezdetben nincsen pontja.
     */
    public Player(){
        super();
        score = 0;
        setOwner(this);
    }

    public Player(String name){
        super();
        score = 0;
        setOwner(this);
        this.name=name;
        Logger.createObject(this, name);
    }

    /**
     * Megadja a játékos aktuális pontszámát.
     * @return A játékos aktuális pontszáma.
     */
    public int getScore() {
        Logger.begin(this, "getScore");
        Logger.end(this, "getScore", Integer.toString(score));
        return score;
    }

    /**
     * Új értékre állítja a játékos pontszámát.
     * @param score Az új érték.
     */
    public void setScore(int score) {
        Logger.begin(this, "setScore");
        this.score = score;
        Logger.end(this, "setScore", "void");
    }

    /**
     * A játékos mozgása.
     * @param dir A mozgatás iránya.
     * @param mOwner Aki a mozgást kezdeményezte.
     * @return Sikeres volt-e a mozgás.
     */
    @Override
    public boolean move(Directions dir, Entity mOwner) {
        Logger.begin(this, "move");
        if (getPlace().getNeighbour(dir).acceptEntity(this, dir, mOwner)){
            if(getPlace()!=null){
                getPlace().removeEntity();
                setPlace(getPlace().getNeighbour(dir));
            }
        } else {
            if(!mOwner.equals(this)){
                die();
                mOwner.addScore(1);
            }
        }
        Logger.end(this, "move", Boolean.toString(true));
        return true;
    }

    /**
     * Pontot ad a játékosnak.
     * @param amount A pontok mennyisége.
     */
    public void addScore(int amount){
        Logger.begin(this, "addScore");
        score+=amount;
        Logger.end(this, "addScore", "void");
    }

    /**
     * Ha a játékos meghal, le vesszük a játéktérről.
     */
    @Override
    public void die(){
        Logger.begin(this, "die");
        getPlace().setHolding(null);
        setPlace(null);
        Logger.end(this, "die", "void");
    }

    /**
     * A játékos lyukra lépését kezeli.
     * @param mOwner A mozgást kezdeményező entitás.
     */
    @Override
    public void stepOnHole(Entity mOwner) {
        Logger.begin(this, "stepOnHole");
        if(!mOwner.equals(this))
            mOwner.addScore(1);
        getWarehouse().removeEntity(this);
        Logger.end(this, "stepOnHole", "void");
    }

    /**
     * A játékos kapcsolóra lépését kezeli. Kompatibilitás céljából megvalósított függvény.
     * @param aSwitch A kapcsolóhoz tartozó lyuk.
     * @param mOwner A mozgást kezdeményező entitás.
     * @see Entity
     * @see Box
     */
    @Override
    public void stepOnSwitch(SwitchableHole aSwitch, Entity mOwner) {
        Logger.begin(this, "stepOnSwitch");
        Logger.end(this, "stepOnSwitch", "void");
    }

    /**
     * A játékos célra lépését kezeli. Kompatibilitás céljából megvalósított függvény.
     * @param mOwner A mozgást kezdeményező entitás.
     * @see Entity
     * @see Box
     */
    @Override
    public void stepOnGoal(Entity mOwner) {
        Logger.begin(this, "stepOnGoal");
        Logger.end(this, "stepOnGoal", "void");
    }
}
