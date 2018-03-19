import sokoban.*;

public class Test11 {
    public static void run(){
        Warehouse Warehouse_1 = new Warehouse("Warehouse_1");
        Cell Cell_1 = new Cell("Cell_1");
        Cell Cell_2 = new Cell("Cell_2");
        Cell Cell_3 = new Cell("Cell_3");
        Wall Wall_1 = new Wall("Wall_1");
        Player Player_1 = new Player("Player_1");
        Player Player_2 = new Player("Player_2");
        Box Box_1 = new Box("Box_1");

        Cell_1.setWarehouse(Warehouse_1);
        Cell_2.setWarehouse(Warehouse_1);
        Cell_3.setWarehouse(Warehouse_1);
        Wall_1.setWarehouse(Warehouse_1);
        Player_1.setWarehouse(Warehouse_1);
        Player_2.setWarehouse(Warehouse_1);
        Box_1.setWarehouse(Warehouse_1);

        Warehouse_1.addPlayer(Player_1);
        Warehouse_1.addPlayer(Player_2);
        Warehouse_1.addBox(Box_1);

        Player_1.setPlace(Cell_1);
        Cell_1.setHolding(Player_1);
        Box_1.setPlace(Cell_2);
        Cell_2.setHolding(Box_1);
        Player_2.setPlace(Cell_3);
        Cell_3.setHolding(Player_2);

        Cell_1.setNeighbour(Cell_2, Directions.right);
        Cell_2.setNeighbour(Cell_1, Directions.left);
        Cell_2.setNeighbour(Cell_3, Directions.right);
        Cell_3.setNeighbour(Cell_2, Directions.left);
        Cell_3.setNeighbour(Wall_1, Directions.right);
        Wall_1.setNeighbour(Cell_3, Directions.left);

        Player_1.move(Directions.right, Player_1);
    }
}