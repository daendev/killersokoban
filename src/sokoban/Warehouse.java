package sokoban;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A játékban a raktárat megvalósító osztály.
 */
public class Warehouse {

    String name;

    /**
     * Azok a cellák, amik ebben a raktárban vannak.
     */
    private Cell[][] map;

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

    public void generateMap(){

        for (int i=0; i<6; i++)
            for (int j=0; j<6; j++) {
                if (i == 0 || j == 0) map[i][j] = new Wall("Fal");
                else if (i == 5 || j == 5) map[i][j] = new Wall("Fal");
                else map[i][j] = new Cell("Csempe");
            }

        map[(new Random()).nextInt(4) + 1][(new Random()).nextInt(3) + 1] = new Hole("Lyuk");

        boxes.add(new Box());
        boxes.get(0).setPlace(map[1][1]);
    }

}
