package graphics.mapelements;

import sokoban.Entity;

public abstract class EntityGraphics extends ObjectGraphics {

    protected Entity reference;

    public EntityGraphics(Entity e){
        reference = e;
    }

    public void update(){
        x = transformCoords(reference.getPlace().getX());
        y = transformCoords(reference.getPlace().getY());
    }
}
