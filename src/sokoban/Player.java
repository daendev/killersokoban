package sokoban;

import graphics.mapelements.ObjectGraphics;
import graphics.mapelements.PlayerGraphics;
import test.Test;

import java.io.FileWriter;
import java.io.IOException;

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
     * A munkás ereje.
     */
    private double strenght;

    /**
     * Létrehozza a játékost. Kezdetben nincsen pontja.
     */
    public Player(){
        super();
        Test.logger.w("Player.constructor()");
        score = 0;
        strenght = 9 + getWeight();
        setWeight(1);
        setOwner(this);
    }

    /**
     * Megadja a játékos aktuális pontszámát.
     * @return A játékos aktuális pontszáma.
     */
    public int getScore() {
        Test.logger.w("Player.getScore()");
        return score;
    }

    /**
     * Új értékre állítja a játékos pontszámát.
     * @param score Az új érték.
     */
    public void setScore(int score) {
        Test.logger.w("Player.setScore()");
        this.score = score;
    }

    /**
     * Visszaadja a munkás erejét.
     * @return A munkás ereje.
     */
    public double getStrenght() {
        Test.logger.w("Player.getStrength()");
        return strenght;
    }

    /**
     * Beállítja a munkás erejét.
     * @param strenght A munkás új ereje.
     */
    public void setStrenght(double strenght) {
        Test.logger.w("Player.setStrength(double)");
        this.strenght = strenght;
    }

    /**
     * A játékos mozgása.
     * @param dir A mozgatás iránya.
     * @param mOwner Aki a mozgást kezdeményezte.
     * @return Sikeres volt-e a mozgás.
     */
    @Override
    public boolean move(Directions dir, Player mOwner, double weight) {
        Test.logger.w("Player.move(Directions, Player, double)");
        if(getPlace()!=null) {
            if (weight + getFriction() <= mOwner.getStrenght()) {
                if (getPlace().getNeighbour(dir).acceptEntity(this, dir, mOwner, getFriction() + weight)) {
                    if (getPlace() != null) {
                        getPlace().removeEntity();
                        setPlace(getPlace().getNeighbour(dir));
                    }
                } else {
                    if (!mOwner.equals(this)) {
                        die();
                        mOwner.addScore(1);
                    }
                }
                return true;
            } else
                return false;
        } else return false;
    }

    public void move(Directions dir){
        Test.logger.w("Player.move(Directions)");
        move(dir,this,0);
    }

    /**
     * Pontot ad a játékosnak.
     * @param amount A pontok mennyisége.
     */
    public void addScore(int amount){
        Test.logger.w("Player.addScore(int)");
        score+=amount;
    }

    /**
     * Ha a játékos meghal, le vesszük a játéktérről.
     */
    @Override
    public void die(){
        Test.logger.w("Player.die()");
        getPlace().setHolding(null);
        setPlace(null);
    }

    /**
     * A játékos lyukra lépését kezeli.
     * @param mOwner A mozgást kezdeményező entitás.
     */
    @Override
    public void stepOnHole(Entity mOwner) {
        Test.logger.w("Player.stepOnHole(Entity)");
        if(!mOwner.equals(this))
            mOwner.addScore(1);
        getWarehouse().removeEntity(this);
    }

    public void applyFluid(Stickyness sticky){
        Test.logger.w("Player.applyFluid(Stickyness)");
        if(getPlace()!=null)
            getPlace().setSticky(sticky);
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
        Test.logger.w("Player.stepOnSwitch(SwitchableHole, Entity)");
    }

    /**
     * A játékos célra lépését kezeli. Kompatibilitás céljából megvalósított függvény.
     * @param mOwner A mozgást kezdeményező entitás.
     * @see Entity
     * @see Box
     */
    @Override
    public void stepOnGoal(Entity mOwner) {
        Test.logger.w("Player.stepOnGoal(Entity)");
    }

    public void draw(){
        Test.logger.w("Player.draw()");
        System.out.print("P");
    }
    public void draw(FileWriter f) throws IOException {
        Test.logger.w("Player.draw(FileWriter)");
        f.write("P");
    }

    @Override
    public ObjectGraphics getGraphics() {
        return new PlayerGraphics(this);
    }
}
