package sokoban;


import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private Cell[] map;
    private List<Box> boxes;
    private Player[] players;

    public Warehouse(){
        players = new Player[2];
        players[0] = new Player(Owner.player1);
        players[1] = new Player(Owner.player2);
        boxes = new ArrayList<>();
    }

    public void addScore(Owner o){
        players[o.ordinal()].setScore(players[o.ordinal()].getScore()+1);
        //TODO átgondolni
    }


    public void removeEntity(Entity e){
        if (boxes.contains(e)) boxes.remove(e);
        else players[e.getOwner().ordinal()].die();
    }

}
