package killersokoban.test;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    public static FileWriter fw;
    public static boolean toFile;

    public Logger(FileWriter fw) {
        Logger.fw = fw;
    }

    public Logger() {
    }

    public void w(String msg){
        if (toFile) {
            try {
                fw.write(msg + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // else System.out.println(msg);
    }
}

