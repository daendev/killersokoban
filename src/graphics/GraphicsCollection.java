package graphics;

import graphics.mapelements.ObjectGraphics;
import javafx.scene.layout.Pane;
import sokoban.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A grafikus elemeket tároló/kezelő osztály.
 */
public class GraphicsCollection {

    /**
     * A grafikai elemek listája.
     */
    private List<ObjectGraphics> objects = new ArrayList<>();

    /**
     * A rajzfelület.
     */
    private Pane canvas;

    /**
     * @param canvas A beállitandó rajzfelület.
     * Beállitja a rejzfelületet a megadott paraméterre.
     */
    public GraphicsCollection(Pane canvas){
        this.canvas = canvas;
    }

    /**
     * @param g A hozzáasandó elem.
     * Hozzáadja a kollekcióhoz a paraméterként kapott elemet.
     */
    public void add(ObjectGraphics g){
        objects.add(g);
    }

    /**
     * @param g Az eltávolitandó elem.
     * Kiveszi a kollekcióból a megadott elemet.
     */
    public void remove(ObjectGraphics g){
        objects.remove(g);
    }

    /**
     * @param w Az alap warehouse ami alapján initelünk
     * A kezelőosztály inicializásálása a megadott warehouse alapján.
     */
    public void initFrom(Warehouse w){
        List<Drawable> mapElements = new ArrayList<>();
        mapElements.addAll(w.getMap());
        mapElements.addAll(w.getPlayers());
        mapElements.addAll(w.getBoxes());
        mapElements.addAll(w.getSwitches());
        for(Drawable d : mapElements){
            add(d.createGraphics());
        }
    }

    /**
     * Minden elem kirajzolása.
     */
    public void drawAll(){
        canvas.getChildren().clear();
        Collections.sort(objects);
        List<ObjectGraphics> deprecated = new ArrayList<>();
        for (ObjectGraphics g : objects){
            if(!g.ping()){
                deprecated.add(g);
                continue;
            }
            canvas.getChildren().add(g.getGraphics());
        }
        objects.removeAll(deprecated);
    }

}
