package graphics;

import graphics.mapelements.ObjectGraphics;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
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
        for (ObjectGraphics g : objects){
            g.update();
            System.out.println("drawing shape " + g.toString() + " at " + g.getX() + "," + g.getY());
            canvas.getChildren().add(g.getShape());
        }
    }

}
