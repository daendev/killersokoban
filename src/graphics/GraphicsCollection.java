package graphics;

import graphics.mapelements.ObjectGraphics;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public class GraphicsCollection {

    private static List<ObjectGraphics> objects = new ArrayList<>();

    private Group canvas;

    public GraphicsCollection(Group canvas){
        this.canvas = canvas;
    }

    public static void add(ObjectGraphics g){
        objects.add(g);
    }

    public static void remove(ObjectGraphics g){
        objects.remove(g);
    }

    public void drawAll(){
        for (ObjectGraphics g : objects){
            canvas.getChildren().add(g.getShape());
        }
    }

}
