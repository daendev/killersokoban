package graphics.mapelements;

import graphics.GraphicsCollection;
import sokoban.Entity;

public abstract class EntityGraphics extends ObjectGraphics {

    protected Entity reference;


    public EntityGraphics(Entity e){
        reference = e;
    }


    public boolean ping(){
        if(reference.getPlace() == null) return false;
        graphics.relocate(transformCoords(reference.getPlace().getX()), transformCoords(reference.getPlace().getY()));
        return true;
    }
}
