package graphics.mapelements;

import graphics.menusystem.GameController;
import javafx.scene.Group;

public abstract class ObjectGraphics implements Comparable<ObjectGraphics>{

    protected Group graphics = new Group();

    protected int z;

    public Group getGraphics(){
        return graphics;
    }

    protected int transformCoords(int x){
        return x* GameController.cellSize;
    }

    public int getZ(){
        return z;
    }

    public int compareTo(ObjectGraphics o){
        return z - o.getZ();
    }

    public abstract boolean ping();
}
