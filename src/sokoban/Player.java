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
    }

    /**
     * Megadja a játékos aktuális pontszámát.
     * @return A játékos aktuális pontszáma.
     */
    public int getScore() {
        return score;
    }

    /**
     * Új értékre állítja a játékos pontszámát.
     * @param score Az új érték.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * A játékos mozgása.
     * @param dir A mozgatás iránya.
     * @param mOwner Aki a mozgást kezdeményezte.
     * @return Sikeres volt-e a mozgás.
     */
    @Override
    public boolean move(Directions dir, Entity mOwner) {
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
        return true;
    }

    /**
     * Pontot ad a játékosnak.
     * @param amount A pontok mennyisége.
     */
    public void addScore(int amount){
        score+=amount;
    }

    /**
     * Ha a játékos meghal, le vesszük a játéktérről.
     */
    @Override
    public void die(){
        getPlace().setHolding(null);
        setPlace(null);
    }

    /**
     * A játékos lyukra lépését kezeli.
     * @param mOwner A mozgást kezdeményező entitás.
     */
    @Override
    public void stepOnHole(Entity mOwner) {
        if(!mOwner.equals(this))
            mOwner.addScore(1);
        getWarehouse().removeEntity(this);
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

    }

    /**
     * A játékos célra lépését kezeli. Kompatibilitás céljából megvalósított függvény.
     * @param mOwner A mozgást kezdeményező entitás.
     * @see Entity
     * @see Box
     */
    @Override
    public void stepOnGoal(Entity mOwner) {

    }
}
