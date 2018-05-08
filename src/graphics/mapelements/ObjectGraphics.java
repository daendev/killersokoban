package graphics.mapelements;

import javafx.scene.Group;

public abstract class ObjectGraphics implements Comparable<ObjectGraphics>{

    protected Group graphics = new Group();

    protected static final int cellSize = 50;

    protected int z;

    int x, y;

    public Group getGraphics(){
        return graphics;
    }

    protected int transformCoords(int x){
        return x*cellSize;
    }

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

    public abstract boolean ping();
}
