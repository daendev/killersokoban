package sokoban;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A játékban a raktárat megvalósító osztály.
 */
public class Warehouse {

    /**
     * Azok a cellák, amik ebben a raktárban vannak.
     */
    private List<Cell> map;

    /**
     * A raktárban található dobozok.
     */
    private List<Box> boxes;

    /**
     * A raktárban található játékosok.
     */
    private List<Player> players;

    /**
     * Létrehozza a raktárat.
     */
    public Warehouse(){
        players = new ArrayList<>();
        boxes = new ArrayList<>();
    }

    /**
     * Létrehozza a raktárat adott számú játékossal.
     * @param playerNum Ahány játékos legyen.
     */
    public Warehouse(int playerNum){
        players = new ArrayList<>();
        for (int i=0; i<playerNum; i++)
            players.add(new Player());
        boxes = new ArrayList<>();
    }

    /**
     * A raktárban valamelyik játékost adja vissza.
     * @param a A játékos sorszáma.
     * @return A kért játékos.
     */
    public Player getPlayers(int a) {
        return players.get(a);
    }

    /**
     * Hozzáad egy dobozt a raktárhoz.
     * @param b A hozzáadandó doboz.
     */
    public void addBox(Box b){
        boxes.add(b);
    }


    /**
     * Kivesz egy entitást a raktárból.
     * @param e A kivevendő entitás.
     * @see Entity
     * @see Box
     * @see Player
     */
    public void removeEntity(Entity e){
        if (boxes.contains(e)) boxes.remove(e);
        else if(players.contains(e)) e.die();
    }

    public void draw(){
        for (Cell c: map
             ) {
            c.draw();
            if (c.getNeighbour(Directions.right) == null)
                System.out.println("");
        }
    }

    public void generateMap(int dim){

        map = new ArrayList<Cell>();

        for (int i=0; i<dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (i == 0 || j == 0) map.add(new Wall());
                else if (i == dim-1 || j == dim-1) map.add(new Wall());
                else map.add(new Cell());
            }
        }

        int a = (new Random()).nextInt(dim/2) + 1;
        int b = (new Random()).nextInt(dim/3) + 1;

        map.remove(a*dim+b);
        map.add(a*dim+b, new Hole());


        for (Cell c: map
             ) {
            if (map.indexOf(c) % dim != dim-1) {
                c.setNeighbour(map.get(map.indexOf(c)+1), Directions.right);
            }
        }


        boxes.add(new Box());
        boxes.get(0).setPlace(map.get(dim+1));
        map.get(dim+1).setHolding(boxes.get(0));
    }

}
