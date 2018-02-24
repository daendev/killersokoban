package sokoban;

public class Wall extends Cell {

    @Override
    public boolean canMoveHere(Directions dir) {
        return false;
    }
}
