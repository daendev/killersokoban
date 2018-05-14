package graphics;

import graphics.mapelements.ObjectGraphics;
import javafx.scene.layout.Pane;
import sokoban.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphicsCollection {

    private List<ObjectGraphics> objects = new ArrayList<>();

    private Pane canvas;

    public GraphicsCollection(Pane canvas){
        this.canvas = canvas;
    }

    public void add(ObjectGraphics g){
        objects.add(g);
    }

    public void remove(ObjectGraphics g){
        objects.remove(g);
    }

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
