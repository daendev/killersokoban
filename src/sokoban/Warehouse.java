package sokoban;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A játékban a raktárat megvalósító osztály.
 */
public class Warehouse {

    String name;

    public Warehouse(String name){
        players = new ArrayList<>();
        boxes = new ArrayList<>();
        this.name = name;
        Logger.createObject(this, name);
    }

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
        for (int i=0; i<playerNum; i++) {
            Player p = new Player();
            players.add(p);
            Logger.createObject(p, new String("player" + i));
        }
        boxes = new ArrayList<>();
    }

    /**
     * A raktárban valamelyik játékost adja vissza.
     * @param a A játékos sorszáma.
     * @return A kért játékos.
     */
    public Player getPlayers(int a) {
        Logger.begin(this, "getPlayers");
        Logger.end(this, "getPlayers", players.get(a).toString());
        return players.get(a);
    }

    /**
     * Hozzáad egy dobozt a raktárhoz.
     * @param b A hozzáadandó doboz.
     */
    public void addBox(Box b){
        Logger.begin(this, "addBox");
        Logger.end(this, "addBox", "void");
        boxes.add(b);
    }


    public void addPlayer(Player p){
        players.add(p);
    }


    /**
     * Kivesz egy entitást a raktárból.
     * @param e A kivevendő entitás.
     * @see Entity
     * @see Box
     * @see Player
     */
    public void removeEntity(Entity e){
        Logger.begin(this, "removeEntity");
        if (boxes.contains(e)) boxes.remove(e);
        else if(players.contains(e)) e.die();
        Logger.end(this, "removeEntity", "void");
    }

    public void generateMap(){

        map = new Cell[6][6];

        for (int i=0; i<6; i++)
            for (int j=0; j<6; j++) {
                if (i == 0 || j == 0) map[i][j] = new Wall("Falacska[" + i + "]-[" + j +"]");
                else if (i == 5 || j == 5) map[i][j] = new Wall("Falacska[" + i + "]-[" + j +"]");
                else map[i][j] = new Cell("Csempecske[" + i + "]-[" + j +"]");
            }

            int a = (new Random()).nextInt(4) + 1;
            int b = (new Random()).nextInt(3) + 1;

            map[a][b] = new Hole("Csempecske[" + a + "]-[" + b +"]");

        boxes.add(new Box("Dobozka"));
        boxes.get(0).setPlace(map[1][1]);
    }

}
