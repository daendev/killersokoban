package graphics.mapelements;

import javafx.scene.shape.Shape;

import java.awt.*;

public abstract class ObjectGraphics {

    protected Shape shape;

    protected static final int cellSize = 50;

    int x, y;

    public Shape getShape(){
        return shape;
    }

    protected int transformCoords(int x){
        return x*cellSize;
    }

    public abstract void update();

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
