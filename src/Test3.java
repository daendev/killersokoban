import sokoban.Cell;
import sokoban.Directions;
import sokoban.Player;
import sokoban.Wall;

public class Test3 {
    public static void run(){
        Cell Cell_1 = new Cell("Cell_1");
        Wall Wall_1 = new Wall("Wall_1");
        Player Player_1 = new Player("Player_1");
        Player_1.setPlace(Cell_1);
        Cell_1.setHolding(Player_1);
        Cell_1.setNeighbour(Wall_1, Directions.right);
        Wall_1.setNeighbour(Cell_1, Directions.left);
        Player_1.move(Directions.right, Player_1);
    }
}
