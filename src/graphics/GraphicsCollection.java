package graphics;

import graphics.mapelements.ObjectGraphics;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphicsCollection {

    private static List<ObjectGraphics> objects = new ArrayList<>();

    private Pane canvas;

    public GraphicsCollection(Pane canvas){
        this.canvas = canvas;
    }

    public static void add(ObjectGraphics g){
        objects.add(g);
    }

    public static void remove(ObjectGraphics g){
        objects.remove(g);
    }

    public void drawAll(){
        canvas.getChildren().clear();
        Collections.sort(objects);
        List<ObjectGraphics> deprecated = new ArrayList<>();
        for (ObjectGraphics g : objects){
            if(!g.isPresent()){
                deprecated.add(g);
                continue;
            }
            g.update();
            // System.out.println("drawing shape " + g.toString() + " at " + g.getX() + "," + g.getY());
            canvas.getChildren().add(g.getShape());
        }
        objects.removeAll(deprecated);
    }

}
