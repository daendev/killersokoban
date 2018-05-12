package graphics.mapelements;

import graphics.menusystem.GameController;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import sokoban.Hole;

public class HoleGraphics extends CellGraphics {

    public HoleGraphics(Hole h) {
        super(h);
        ((Rectangle)graphics.getChildren().get(0)).setFill(Color.web("616161"));

        // small square
        int smallSize = (int) (0.8 * GameController.cellSize);
        int smallPos = (int) (0.4 * GameController.cellSize);
        Paint smallColor = Color.web("212121");

        // medium square
        int mediumSize = (int) (0.6 * GameController.cellSize);
        int mediumPos = (int) (0.4 * GameController.cellSize);
        Paint mediumColor = Color.web("424242");

        Rectangle mediumRect = new Rectangle();
        mediumRect.setHeight(mediumSize);
        mediumRect.setWidth(mediumSize);
        mediumRect.setX(mediumPos);
        mediumRect.setY(mediumPos);
        mediumRect.setFill(mediumColor);

        Rectangle smallRect = new Rectangle();
        smallRect.setHeight(smallSize);
        smallRect.setWidth(smallSize);
        smallRect.setX(smallPos);
        smallRect.setY(smallPos);
        smallRect.setFill(smallColor);

        graphics.getChildren().addAll(mediumRect, smallRect);
    }

}