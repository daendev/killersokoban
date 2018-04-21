import sokoban.*;


public class Main {

    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        Test t = new Test(w);
        boolean exit = false;
        while(!exit){
            t.readCommand();
            exit = t.executeCommand();
        }
    }
}
