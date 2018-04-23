import sokoban.*;

public class Main {

    public static void main(String[] args) {
        String load = "";
        for(int i = 0; i<args.length; i++){
            switch (args[i]){
                case "-in":
                    load = args[i++];
                    break;
                case "-out":
                    break;
                case "-log":
                    break;
                default:
                    System.out.println("Wrong argument: " + args[i]);
                    break;
            }
        }
        Warehouse w = new Warehouse();



        Test t = new Test(w, new Logger());  // paraméter teszt
        boolean exit = false;
        if(!load.equals("")) t.load(load);
        while(!exit){
            t.readCommand();
            exit = t.executeCommand();
        }
    }
}
