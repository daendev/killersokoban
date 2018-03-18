import sokoban.Cell;
import sokoban.Directions;
import sokoban.Hole;
import sokoban.Player;

public class Test4 {
    public static void run(){
        Cell Cell_1 = new Cell("Cell_1");
        Hole Hole_1 = new Hole("Hole_1");
        Player Player_1 = new Player("Player_1");
        Player_1.setPlace(Cell_1);
        Cell_1.setHolding(Player_1);
        Cell_1.setNeighbour(Hole_1, Directions.right);
        Hole_1.setNeighbour(Cell_1, Directions.left);
        Player_1.move(Directions.right, Player_1);
    }
}
