package graphics.mapelements;

import graphics.menusystem.GameController;
import javafx.scene.Group;

/**
 * Pályaelemek grafikályának általános összefoglaló osztálya
 */
public abstract class ObjectGraphics implements Comparable<ObjectGraphics>{

    /**
     * Grafiaki csoport
     */
    protected Group graphics = new Group();

    /**
     * Z koordináta
     */
    protected int z;

    /**
     * Síkbeli koordináták
     */
    int x, y;

    /**
     * graphics getterje
     * @return graphics
     */
    public Group getGraphics(){
        return graphics;
    }

    /**
     * Képernyő méret és pálya méret arányos változtatása
     * @param x Koordináta
     * @return Új koordináta
     */
    protected int transformCoords(int x){
        return x* GameController.cellSize;
    }

    /**
     * X koordináta getterje
     * @return X koordináta
     */
    public int getX(){
        return x;
    }

    /**
     * Y koordináta getterje
     * @return Y koordináta
     */
    public int getY(){
        return y;
    }

    /**
     * Z koordináta getterje
     * @return Z koordináta
     */
    public int getZ(){
        return z;
    }

    /**
     * Magasság összehasonlítása
     * @param o Az összehasonlítandó objektum
     * @return Melyik van előrébb a képernyőn
     */
    public int compareTo(ObjectGraphics o){
        return z - o.getZ();
    }

    public abstract boolean ping();
}
