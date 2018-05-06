package graphics;

import graphics.mapelements.ObjectGraphics;

import java.util.ArrayList;
import java.util.List;

public class GraphicsCollection {

    private static List<ObjectGraphics> objects = new ArrayList<>();

    public static void add(ObjectGraphics g){
        objects.add(g);
    }

    public static void remove(ObjectGraphics g){
        objects.remove(g);
    }

}
