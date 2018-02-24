import sokoban.Cell;
import sokoban.*;

public class Main {

    public static void main(String[] args) {
        //try {
            Cell cells[] = new Cell[3];
            for (int i = 0; i < cells.length; i++)
                cells[i] = new Cell();


            cells[0].setNeighbour(cells[1], Directions.left);
            cells[1].setNeighbour(cells[2], Directions.left);
            Player a = new Player(Owner.player1);
            a.setPlace(cells[0]);
            Entity b = new Box();
            b.setPlace(cells[1]);

            cells[0].setHolding(a);
            cells[1].setHolding(b);

            a.move(Directions.left, a.getOwner());

            if (cells[1].getHolding().equals(a))
                System.out.println("nemyo");
            else
                System.out.println("yo");

        //} catch (Exception e){}
    }
}
