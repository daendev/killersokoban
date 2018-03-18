import sokoban.Cell;
import sokoban.Directions;
import sokoban.Player;

public class Test2 {
    public static void run(){
        Cell Cell_1 = new Cell("Cell_1");
        Cell Cell_2 = new Cell("Cell_2");
        Player Player_1 = new Player("Player_1");
        Player_1.setPlace(Cell_1);
        Cell_1.setHolding(Player_1);
        Cell_1.setNeighbour(Cell_2, Directions.right);
        Cell_2.setNeighbour(Cell_1, Directions.left);
        Player_1.move(Directions.right, Player_1);
    }
}
