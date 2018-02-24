package sokoban;


public class Warehouse {

    private Cell[] map;
    private Box[] boxes;
    private Player[] players;

    public Warehouse(){
        players = new Player[2];
        players[0] = new Player(Owner.player1);
        players[1] = new Player(Owner.player2);
    }

    public void addScore(Owner o){
        players[o.ordinal()].setScore(players[o.ordinal()].getScore()+1);
        //TODO átgondolni
    }


}
