import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    static FileWriter fw;
    static boolean toFile;

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
        else System.out.println(msg);
    }
}

