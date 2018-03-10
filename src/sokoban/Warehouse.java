package sokoban;


import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private Cell[] map;
    private List<Box> boxes;
    private List<Player> players;

    public Warehouse(){
        players = new ArrayList<>();
        boxes = new ArrayList<>();
    }

    public Warehouse(int playerNum){
        players = new ArrayList<>();
        for (int i=0; i<playerNum; i++)
            players.add(new Player());
        boxes = new ArrayList<>();
    }

    public Player getPlayers(int a) {
        return players.get(a);
    }

    public void addBox(Box b){
        boxes.add(b);
    }


    public void removeEntity(Entity e){
        if (boxes.contains(e)) boxes.remove(e);
        else if(players.contains(e)) e.die();
    }

}
