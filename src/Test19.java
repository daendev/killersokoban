import sokoban.*;

public class Test19 {
    public static void run(){
        Cell Cell_1 = new Cell("Cell_1");
        Cell Cell_2 = new Cell("Cell_2");
        Goal Goal_1 = new Goal("Goal_1");
        Player Player_1 = new Player("Player_1");
        Box Box_1 = new Box("Box_1");
        Player_1.setPlace(Cell_1);
        Cell_1.setHolding(Player_1);
        Box_1.setPlace(Cell_2);
        Cell_2.setHolding(Box_1);
        Cell_1.setNeighbour(Cell_2, Directions.right);
        Cell_2.setNeighbour(Cell_1, Directions.left);
        Cell_2.setNeighbour(Goal_1, Directions.right);
        Goal_1.setNeighbour(Cell_2, Directions.left);
        Player_1.move(Directions.right, Player_1);
    }
}
