package graphics.mapelements;

import graphics.menusystem.GameController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import sokoban.Player;

public class PlayerGraphics extends EntityGraphics {

    private static final int radius = GameController.cellSize / 2;
    private static int playerCount = 1;

    public PlayerGraphics(Player p) {
        super(p);
        z = 1;
        Circle c = new Circle();
        c.setRadius(radius);
        c.setFill(Color.web(chooseColor()));
        ++playerCount;
        graphics.getChildren().add(c);
    }

    private String chooseColor(){
        switch(playerCount){
            case 1: return "2196F3";
            case 2: return "F44336";
            case 3: return "4CAF50";
            case 4: return "FFEB3B";
        }
        return "9C27B0"; // default lila csak ugy random xd
    }

}
