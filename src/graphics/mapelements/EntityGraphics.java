package graphics.mapelements;

import sokoban.Entity;

public abstract class EntityGraphics extends ObjectGraphics {

    protected Entity reference;

    public EntityGraphics(Entity e){
        reference = e;
    }
}
