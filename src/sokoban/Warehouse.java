package sokoban;


import java.util.ArrayList;
import java.util.List;


/**
 * A játékban a raktárat megvalósító osztály.
 */
public class Warehouse {

    /**
     * Azok a cellák, amik ebben a raktárban vannak.
     */
    private Cell[] map;

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

}
