import sokoban.Cell;
import sokoban.*;

public class Main {

    public static void main(String[] args) {

        Cell[] cells = new Cell[3];
        cells[0] = new Cell();
        cells[1] = new Cell();
        cells[2] = new Cell();

        cells[0].setNeighbour(cells[1],Directions.left);
        cells[1].setNeighbour(cells[2],Directions.left);
        Entity a = new Entity();
        a.setPlace(cells[0]);
        Entity b = new Entity();
        b.setPlace(cells[1]);

        cells[0].setHolding(a);
        cells[1].setHolding(b);

        a.move(Directions.left);

        if (b.getPlace().getNeighbour(Directions.left) != null)
            System.out.println("nemyo");
        else
            System.out.println("yo");

    }

}
