package sokoban;

public class Wall extends Cell {

    @Override
    public boolean acceptEntity(Entity n, Directions dir, Entity owner) {
        return false;
    }
}
