package graphics.menusystem;

import graphics.GraphicsCollection;
import graphics.SokobanApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sokoban.Directions;
import sokoban.Player;
import sokoban.Warehouse;

import static javafx.scene.input.KeyCode.*;

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


        int x = 4, y = 4;
        Player p = new Player();
        p.setPlace(warehouse.getMap().get(x + y*warehouse.getMapWidth()));
        warehouse.getMap().get(x + y*warehouse.getMapWidth()).setHolding(p);
        warehouse.add(p);
        p.setWarehouse(warehouse);

        drawables.drawAll();
    }

    public void handleKeyPress(KeyEvent key){
        System.out.println("Running keypress code");
        switch(key.getCode()){
            case A:
                warehouse.getPlayer(0).move(Directions.left);
                break;
            case D:
                warehouse.getPlayer(0).move(Directions.right);
                break;
            case W:
                warehouse.getPlayer(0).move(Directions.top);
                break;
            case S:
                warehouse.getPlayer(0).move(Directions.bottom);
                break;
        }
        drawables.drawAll();
    }

    public void exitButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("main");
    }


}
