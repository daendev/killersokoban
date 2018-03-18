import sokoban.*;

public class Test18 {
    public static void run(){
        Cell Cell_1 = new Cell("Cell_1");
        Goal Goal_1 = new Goal("Goal_1");
        Player Player_1 = new Player("Player_1");
        Player_1.setPlace(Cell_1);
        Cell_1.setHolding(Player_1);
        Cell_1.setNeighbour(Goal_1, Directions.right);
        Goal_1.setNeighbour(Cell_1, Directions.left);
        Player_1.move(Directions.right, Player_1);
    }
}
