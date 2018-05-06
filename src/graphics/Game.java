package graphics;

import javafx.scene.layout.Pane;
import sokoban.Warehouse;

public class Game extends Pane {

    private GraphicsCollection drawables;

    private Warehouse warehouse;

    public Game(){
        setPrefSize(500,500);
        drawables = new GraphicsCollection(this);
        warehouse = new Warehouse();
        warehouse.generateMap(10,10);
        drawables.drawAll();
    }

}
