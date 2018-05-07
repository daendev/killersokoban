package graphics.menusystem;

import graphics.GraphicsCollection;
import graphics.SokobanApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sokoban.Warehouse;

public class GameController {

    @FXML
    private Pane canvas;

    private GraphicsCollection drawables;

    private Warehouse warehouse;


    public void initialize(){
        canvas.setPrefSize(500,500);
        drawables = new GraphicsCollection(canvas);
        warehouse = new Warehouse();
        warehouse.generateMap(10,10);
        drawables.drawAll();
    }

    public void exitButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("main");
    }
}
