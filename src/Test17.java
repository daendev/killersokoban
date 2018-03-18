import sokoban.*;

public class Test17 {
    public static void run(){
        Cell Cell_1 = new Cell("Cell_1");

        SwitchableHole SwitchableHole_1 = new SwitchableHole("SwitchableHole_1");

        Switch Switch_1 = new Switch("Switch_1", SwitchableHole_1);
        Player Player_1 = new Player("Player_1");
        Box Box_1 = new Box("Box_1");

        Player_1.setPlace(Cell_1);
        Cell_1.setHolding(Player_1);
        Box_1.setPlace(SwitchableHole_1);
        SwitchableHole_1.setHolding(Box_1);

        Cell_1.setNeighbour(SwitchableHole_1, Directions.right);
        SwitchableHole_1.setNeighbour(Cell_1, Directions.left);
        SwitchableHole_1.setNeighbour(Switch_1, Directions.right);
        Switch_1.setNeighbour(SwitchableHole_1, Directions.left);

        Player_1.move(Directions.right, Player_1);
    }
}
