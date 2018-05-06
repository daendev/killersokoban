package graphics.mapelements;

import javafx.scene.shape.Shape;

public abstract class ObjectGraphics {

     protected Shape shape;

    private static final int cellSize = 50;

    public Shape getShape(){
        return shape;
    }

    protected int transformCoords(int x){
        return x*cellSize;
    }
}
