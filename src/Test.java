import sokoban.Warehouse;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Test {

    private List<String> command;
    private Warehouse w;

    Test(Warehouse w){
        w=this.w;
    }

    public void readCommand(){
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        String s = "";
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        command = Arrays.asList(s.split(" "));

        for (int i = 0; i < command.size(); i++) {
            System.out.println(command.get(i));
        }
    }

    public void executeCommand(){
        switch (command.get(0)) {


            case "save":
                if (command.size() == 1)
                    System.out.println("Hiányzó fájlnév!");
                else
                    save(command.get(1));
        }
    }

    public void save(String fileName){
        try {
            FileWriter file = new FileWriter(fileName);
            file.write(w.getMapWidth() + " " + w.getMapHeight() + "\n");
            w.draw(file);
            file.write(w.getPlayers().size() + "\n");
            for (int i=0; i<w.getPlayers().size(); i++) {
                file.write(w.getPlayers().get(i).getPlace().getX() + " ");
                file.write(w.getPlayers().get(i).getPlace().getY() + "\n");
            }

            file.write(w.getBoxes().size() + "\n");
            for (int i=0; i<w.getBoxes().size(); i++) {
                file.write(w.getBoxes().get(i).getPlace().getX() + " ");
                file.write(w.getBoxes().get(i).getPlace().getY() + "\n");
            }

            file.write("kapcsolók");


            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}