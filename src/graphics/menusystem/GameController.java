package graphics.menusystem;

import graphics.GraphicsCollection;
import graphics.SokobanApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sokoban.Box;
import sokoban.Directions;
import sokoban.Player;
import sokoban.Warehouse;

import static javafx.scene.input.KeyCode.*;

public class GameController {

    @FXML
    private Pane canvas;

    private GraphicsCollection drawables;

    private Warehouse warehouse;

    public static int cellSize;

    private static final int canvasSize = 500;


    public void initialize(){
        warehouse = new Warehouse();
        warehouse.generateMap();
        cellSize = Math.min(canvasSize / warehouse.getMapWidth(), canvasSize /warehouse.getMapHeight());
        drawables = new GraphicsCollection(canvas);
        canvas.setMaxSize(cellSize*warehouse.getMapWidth(),cellSize*warehouse.getMapHeight());

//        int x,y;
//        x = 4;
//        y = 4;
//        Player p = new Player();
//        p.setPlace(warehouse.getMap().get(x + y*warehouse.getMapWidth()));
//        warehouse.getMap().get(x + y*warehouse.getMapWidth()).setHolding(p);
//        warehouse.getPlayers().add(p);
//        p.setWarehouse(warehouse);
//
//        x = 5;
//        y = 5;
//        Box b = new Box();
//        b.setPlace(warehouse.getMap().get(x + y*warehouse.getMapWidth()));
//        warehouse.getMap().get(x + y*warehouse.getMapWidth()).setHolding(b);
//        warehouse.addBox(b);
//        b.setWarehouse(warehouse);
//
//        x = 5;
//        y = 6;
//        Player p2 = new Player();
//        p2.setPlace(warehouse.getMap().get(x + y*warehouse.getMapWidth()));
//        warehouse.getMap().get(x + y*warehouse.getMapWidth()).setHolding(p2);
//        warehouse.getPlayers().add(p2);
//        p2.setWarehouse(warehouse);

        drawables.initFrom(warehouse);
        drawables.drawAll();
    }

    public void handleKeyPress(KeyEvent key){
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


    public void saveButton(ActionEvent actionEvent) {
    }
}
