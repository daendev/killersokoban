package killersokoban.graphics.mapelements;

import killersokoban.graphics.menusystem.GameController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import killersokoban.sokoban.Goal;

public class GoalGraphics extends CellGraphics {

    private static int value;

    /**
     * @param c A kirajzolandó Goal
     * Kirajzolja a goalt.
     */
    public GoalGraphics(Goal c) {
        super(c);
        value = GameController.cellSize / 8;
        Line line1 = new Line();
        line1.setStartX(value);
        line1.setStartY(value);
        line1.setEndX(GameController.cellSize - value);
        line1.setEndY(GameController.cellSize - value);
        line1.setStrokeWidth(value);
        line1.setStroke(Color.web("8BC34A"));
        line1.setStrokeLineCap(StrokeLineCap.ROUND);
        Line line2 = new Line();
        line2.setStartX(value);
        line2.setStartY(GameController.cellSize - value);
        line2.setEndX(GameController.cellSize - value);
        line2.setEndY(value);
        line2.setStrokeWidth(GameController.cellSize / 8);
        line2.setStroke(Color.web("8BC34A"));
        line1.setStrokeLineCap(StrokeLineCap.ROUND);
        graphics.getChildren().addAll(line1, line2);
    }

}
