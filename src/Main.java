import sokoban.*;


public class Main {

    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        w.generateMap(20);
        w.draw();
    }
}
