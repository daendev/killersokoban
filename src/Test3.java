import sokoban.*;

public class Test3 {
    public static void run(){
        Warehouse Warehouse_1 = new Warehouse("Warehouse_1");
        Cell Cell_1 = new Cell("Cell_1");
        Wall Wall_1 = new Wall("Wall_1");
        Player Player_1 = new Player("Player_1");

        Cell_1.setWarehouse(Warehouse_1);
        Wall_1.setWarehouse(Warehouse_1);
        Player_1.setWarehouse(Warehouse_1);

        Warehouse_1.addPlayer(Player_1);

        Player_1.setPlace(Cell_1);
        Cell_1.setHolding(Player_1);

        Cell_1.setNeighbour(Wall_1, Directions.right);
        Wall_1.setNeighbour(Cell_1, Directions.left);

        Player_1.move(Directions.right, Player_1);
    }
}