package sokoban;
import graphics.Drawable;
import graphics.mapelements.BoxGraphics;
import graphics.mapelements.ObjectGraphics;
import test.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A játékban a dobozokat megvalósító osztály.
 * @see Entity
 */
public class Box extends Entity implements Drawable{
    /**
     * Létrehozza a dobozt.
     * Kezdetben a doboz tulajdonosa saját maga, mivel még senki nem tolta egy cél cellára.
     */
    public Box()
    {
        super();
        Test.logger.w("Box.constructor()");
        setOwner(this);
        setWeight(2);
    }

    /**
     * A doboz arrébtolása.
     * @param dir A tolás iránya
     * @param mOwner Ki kezdeményezte a tolást
     * @return Sikeresen arrébb tolódott-e a doboz.
     */
    @Override
    public boolean move(Directions dir, Player mOwner, double weight) {
        Test.logger.w("Box.move(Directions, Player, double)");
        if (weight + getFriction() <= mOwner.getStrenght()) {
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

    @Override
    public boolean canMove(Directions dir, double weight, double strength) {
        if(strength >= weight + getFriction())
            return getPlace().getNeighbour(dir).canMoveHere(dir, weight, strength);
        return false;
    }

    /**
     * A doboz célra tolódását kezeli.
     * Beállítja a tulajdonosát arra, aki betolta a célba, majd pontot ad neki.
     * @param mOwner Aki a tolást kezdeményezte, és így a helyére tolta.
     */
    @Override
    public void stepOnGoal(Entity mOwner) {
        Test.logger.w("Box.stepOnGoal(Entity)");
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
        Test.logger.w("Box.stepOnHole(Entity)");
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
        Test.logger.w("Box.stepOnSwitch(SwichableHole, Entity)");
        aSwitch.setOpen(true, mOwner);
    }

    /**
     * Kompatibilitás céljából megvalósított függvény.
     * @see Entity
     * @see Player
     */
    @Override
    public void die() {
        Test.logger.w("Box.die()");

    }

    /**
     * Kompatibilitás céljából megvalósított függvény.
     * @see Entity
     * @see Player
     */
    @Override
    public void addScore(int amount){
        Test.logger.w("Box.addScore(int)");
    }

    @Override
    public void draw() {
        Test.logger.w("Box.draw()");
        System.out.print("B");
    }

    @Override
    public void draw(FileWriter f) throws IOException {
        Test.logger.w("Box.draw(FileWriter)");
        f.write("B");
    }

    @Override
    public ObjectGraphics createGraphics() {
        return new BoxGraphics(this);
    }
}
