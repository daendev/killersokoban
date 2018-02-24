import sokoban.Cell;
import sokoban.*;

public class Main {

    public static void main(String[] args) {
        //try {
            Cell cells[] = new Cell[6];
            for (int i = 0; i < cells.length; i++)
                cells[i] = new Cell();


            Warehouse w = new Warehouse();
            SwitchableHole sh = new SwitchableHole();

            //cells[3] = new Wall();
            cells[3] = sh;
            cells[2] = new Switch(sh);

            cells[0].setNeighbour(cells[1], Directions.left);
            cells[1].setNeighbour(cells[2], Directions.left);
            cells[2].setNeighbour(cells[3], Directions.left);
            cells[3].setNeighbour(cells[4], Directions.left);
            cells[4].setNeighbour(cells[5], Directions.left);


            w.getPlayers(0).setPlace(cells[0]);
            //w.getPlayers(1).setPlace(cells[2]);
            Box b = new Box();
            //Entity b2 = new Box();
            b.setPlace(cells[1]);
            //b2.setPlace(cells[3]);

            cells[0].setHolding(w.getPlayers(0));
            cells[1].setHolding(b);
            //cells[2].setHolding(w.getPlayers(1));
            //cells[3].setHolding(b2);

            cells[3].setWarehouse(w);
            w.addBox(b);

            w.getPlayers(0).move(Directions.left,w.getPlayers(0).getOwner());
            w.getPlayers(0).move(Directions.left,w.getPlayers(0).getOwner());

            if (cells[3].getHolding()==null)
                System.out.println("nemyo");
            else
                System.out.println("yo");
            System.out.println(w.getPlayers(0).getScore());

        //} catch (Exception e){}
    }
}
