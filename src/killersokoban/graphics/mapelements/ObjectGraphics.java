package killersokoban.graphics.mapelements;

import killersokoban.graphics.menusystem.GameController;
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
    int z;


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
    int transformCoords(int x){
        return x* GameController.cellSize;
    }

    /**
     * Z koordináta getterje
     * @return Z koordináta
     */
    private int getZ(){
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

    /**
     * Modell lekérdezése és grafika frissítése.
     * @return igaz, ha az objektumot még ki kell rajzolni.
     */
    public abstract boolean ping();
}
