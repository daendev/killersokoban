package killersokoban.graphics.mapelements;

import killersokoban.sokoban.Entity;

/**
 * Az entityk grafikájának kezelése.
 */
public abstract class EntityGraphics extends ObjectGraphics {

    /**
     * Referencia entity.
     */
    protected Entity reference;


    /**
     * @param e A referencia entity
     * Beállitja a referenciát a paraméterben megadottra.
     */
    public EntityGraphics(Entity e){
        reference = e;
    }


    /**
     * @return pályán van e az adott elem, vagy már nem
     * Updateli a grafikát.
     */
    public boolean ping(){
        if(reference.getPlace() == null) return false;
        graphics.relocate(transformCoords(reference.getPlace().getX()), transformCoords(reference.getPlace().getY()));
        return true;
    }
}
