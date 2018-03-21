import sokoban.*;


public class Main {

    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        w.generateMap(10);
        w.draw();
    }
}
