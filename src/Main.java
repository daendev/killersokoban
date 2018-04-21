import sokoban.*;


public class Main {

    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        Test t = new Test(w);
        while(true){
            t.readCommand();
            t.executeCommand();
        }
    }
}
