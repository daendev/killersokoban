package graphics.menusystem;

import graphics.GraphicsCollection;
import graphics.SettingsData;
import graphics.SokobanApp;
import graphics.mapelements.PlayerGraphics;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import sokoban.Directions;
import sokoban.Player;
import sokoban.Warehouse;

/**
 * A játék kezelőosztálya.
 */
public class GameController {

    /**
     * Rajzfelület.
     */
    @FXML
    private Pane canvas;

    @FXML
    private GridPane scorePane;

    private GraphicsCollection drawables;

    private Warehouse warehouse;

    public static int cellSize;

    private static final int canvasSize = 500;


    /**
     * @param players Játékosok száma.
     * Pontszámitó inicializáslása.
     */
    private void initScoreboard(int players){
        scorePane.getChildren().clear();
        Label scoreLabel = new Label("Score");
        scoreLabel.setId("score");
        scoreLabel.setAlignment(Pos.CENTER);
        scorePane.add(scoreLabel, 0, 0, 2, 1);
        for(int i = 1; i <= players; ++i){
            Label playerString = new Label("Player " + i);
            playerString.setId("player" + i + "string");
            scorePane.add(playerString, 0, i);
            Label playerScore = new Label("0");
            playerScore.setId("player" + i + "score");
            scorePane.add(playerScore, 1, i);
        }
    }

    /**
     * Új játék inditása.
     */
    public void newGame(){
        SettingsData settings = new SettingsData(10,10,2);
        settings.read("settings.xml");
        warehouse = new Warehouse(settings.getPlayerCount());
        warehouse.generateMap(settings.getWidth(),settings.getHeight());
        initGame();
    }

    /**
     * Játék betöltése.
     */
    public void loadGame(){
        warehouse = new Warehouse();
        warehouse.load("game.txt");
        initGame();
    }

    /**
     * Játék betöltése vagy új játék elenjén elvégzendő műveletek.
     */
    private void initGame(){
        initScoreboard(warehouse.getPlayers().size());
        cellSize = Math.min(canvasSize / warehouse.getMapWidth(), canvasSize / warehouse.getMapHeight());
        drawables = new GraphicsCollection(canvas);
        canvas.setMaxSize(cellSize*warehouse.getMapWidth(),cellSize*warehouse.getMapHeight());
        drawables.initFrom(warehouse);
        drawables.drawAll();
        updateScore();
    }

    /**
     * @param key A gombnyomás eventje.
     * A gombnyomással történő irányitás kezelése.
     */
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
            case LEFT:
                warehouse.getPlayer(1).move(Directions.left);
                break;
            case RIGHT:
                warehouse.getPlayer(1).move(Directions.right);
                break;
            case UP:
                warehouse.getPlayer(1).move(Directions.top);
                break;
            case DOWN:
                warehouse.getPlayer(1).move(Directions.bottom);
                break;
            case H:
                warehouse.getPlayer(2).move(Directions.left);
                break;
            case K:
                warehouse.getPlayer(2).move(Directions.right);
                break;
            case U:
                warehouse.getPlayer(2).move(Directions.top);
                break;
            case J:
                warehouse.getPlayer(2).move(Directions.bottom);
                break;
            case NUMPAD4:
                warehouse.getPlayer(3).move(Directions.left);
                break;
            case NUMPAD6:
                warehouse.getPlayer(3).move(Directions.right);
                break;
            case NUMPAD8:
                warehouse.getPlayer(3).move(Directions.top);
                break;
            case NUMPAD5:
                warehouse.getPlayer(3).move(Directions.bottom);
                break;
        }
        drawables.drawAll();
        updateScore();
        if(warehouse.endGame()) SokobanApp.switchScenes("main");
    }

    /**
     * Ponttábla updatelése.
     */
    private void updateScore(){
        int i = 1;
        for(Player p : warehouse.getPlayers()){
            ((Label)scorePane.lookup("#player" + i + "score")).setText(String.valueOf(p.getScore()));
            ++i;
        }
    }

    /**
     * @param actionEvent Kilépés event
     * A kilépés gomb kezelője.
     */
    public void exitButton(ActionEvent actionEvent) {
        SokobanApp.switchScenes("main");
    }


    /**
     * @param actionEvent Mentés event.
     * A mentés gomb kezelője.
     */
    public void saveButton(ActionEvent actionEvent) {
        warehouse.save("game.txt");
    }
}
