package graphics.mapelements;

import javafx.scene.shape.Shape;

import java.awt.*;

public abstract class ObjectGraphics {

    protected Shape shape;

    protected static final int cellSize = 50;

    int x, y;

    public Shape getShape(){
        return shape;
    }

    protected int transformCoords(int x){
        return x*cellSize;
    }

    public abstract void update();

    public static Color hex2Rgb(String colorStr) {
        return new Color(
                Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
                Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
                Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
    }
}
