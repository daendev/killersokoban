import sokoban.*;
import test.Logger;
import test.Test;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        Test t = new Test(w);

        String load = "";
        for(int i = 0; i<args.length; i++){
            switch (args[i]){
                case "-in":
                    load = args[++i];
                    break;
                case "-out":
                    t.setFile(true);
                    try {
                        Logger.fw = new FileWriter(args[++i]);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case "-log":
                    Logger.toFile=true;
                    break;
                default:
                    System.out.println("Wrong argument: " + args[i]);
                    break;
            }
        }

        boolean exit = false;
        if(!load.equals("")) t.load(load);
        while(!exit){
            t.readCommand();
            exit = t.executeCommand();
        }
    }
}
