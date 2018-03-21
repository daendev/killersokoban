package sokoban;

/**
 * A játékban a cellákon álló dolgokat megvalósító osztály.
 * @see Box
 * @see Player
 */
public abstract class Entity {

    /**
     * Az a cella, amin az entitás áll.
     */
    private Cell place;

    /**
     * Az entitás tulajdonosa. Kezdetben mindenkinek saját maga, de ez a játék folyamán változhat.
     */
    private Entity owner;

    /**
     * Az entitást tartalmazó raktár.
     */
    private Warehouse warehouse;

    /**
     * Az entitás nehézsége. Tolásnál fontos.
     */
    private double weight;

    /**
     * Létrehozza az entitást.
     */
    public Entity() {
        place = new Cell();
    }

    /**
     * Létrehozza az entitást egy adott cellán.
     * @param p A cella, amin az entitás létrejön.
     */
    Entity(Cell p)
    {
        place = p;
    }

    /**
     * Megadja, hogy melyik raktárban van az entitás.
     * @return Az entitást tartalmazó raktár.
     */
    public Warehouse getWarehouse() {
        return warehouse;
    }

    /**
     * Megadja, hogy ki az entitás tulajdonosa.
     * @return Az entitás tulajdonosa.
     */
    public Entity getOwner() {
        return owner;
    }

    /**
     * Új tulajdonost ad meg az entitásnak.
     * @param owner Az új tulajdonos.
     */
    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    /**
     * Megadja, hogy hol áll az entitás.
     * @return Ahol az entitás áll.
     */
    public Cell getPlace() {
        return place;
    }

    /**
     * Új helyet ad meg az entitásnak
     * @param place Ahova az entitást helyezzük.
     */
    public void setPlace(Cell place) {
        this.place = place;
    }

    /**
     * Az entitás súlyát adja vissza.
     * @return Mennyire nehéz az entitás.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Beállítja az entitás súlyát.
     * @param weight Mennyire legyen nehéz az entitás.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Mennyire nehéz eltolni az entitást a mezőről, amin áll.
     * @return Lásd fönt.
     */
    public double getFriction(){
        return getWeight()*getPlace().getSticky();
    }

    /**
     * Mozgatja az entitást
     * @param dir A mozgatás iránya.
     * @param mOwner Aki a tolást kezdeményezte.
     * @return Sikeresen mozgott-e az entitás.
     */
    public abstract boolean move(Directions dir, Player mOwner, double weight);

    /**
     * Az entitás célra érkezését kezeli.
     * @param mOwner A mozgást kezdeményező entitás.
     */
    public abstract void stepOnGoal(Entity mOwner);

    /**
     * Az entitás lyukra érkezését kezeli.
     * @param mOwner A mozgást kezdeményező entitás.
     */
    public abstract void stepOnHole(Entity mOwner);


    /**
     * Az entitás kapcsolóra érkezését kezeli.
     * @param aSwitch A kapcsolóhoz tartozó lyuk.
     * @param mOwner A mozgást kezdeményező entitás.
     */
    public abstract void stepOnSwitch(SwitchableHole aSwitch, Entity mOwner);

    /**
     * Kompatibilitást szolgáló absztrakt függvény.
     * @param amount A pontok mennyisége.
     */
    public abstract void addScore(int amount);

    /**
     * Kompatibilitást szolgáló absztrakt függvény.
     */
    public abstract void die();
}
