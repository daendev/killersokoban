package graphics.mapelements;

import graphics.GraphicsCollection;
import sokoban.Entity;

public abstract class EntityGraphics extends ObjectGraphics {

    protected Entity reference;

    public EntityGraphics(Entity e){
        reference = e;
    }

    public void update(){
        shape.relocate(transformCoords(reference.getPlace().getX()), transformCoords(reference.getPlace().getY()));
    }

    public boolean isPresent(){
        return reference.getPlace() != null;
    }
}
