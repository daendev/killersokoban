package graphics.mapelements;

import javafx.scene.shape.Shape;

import java.awt.*;

public abstract class ObjectGraphics implements Comparable<ObjectGraphics>{

    protected Shape shape;

    protected static final int cellSize = 50;

    protected int z;

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

    public int getZ(){
        return z;
    }

    public int compareTo(ObjectGraphics o){
        return z - o.getZ();
    }

    public abstract boolean isPresent();
}
