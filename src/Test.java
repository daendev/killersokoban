import sokoban.*;

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
        this.w = w;
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
            case "generate":
                if (command.size() < 2)
                    System.out.println("Túl kevés argumentum!");
                else
                    generate();
                break;

            case "add":
                if (command.size() < 4)
                    System.out.println("Túl kevés argumentum!");
                else
                    add();
                break;

            case "remove":
                if (command.size() < 2)
                    System.out.println("Túl kevés argumentum!");
                else
                    remove();
                break;

            case "changecell":
                if (command.size() < 4)
                    System.out.println("Túl kevés argumentum!");
                else
                    changecell();
                break;

            case "drawmap":
                w.draw();
                break;

            case "listplayers":
                for (int i=0; i<w.getPlayers().size(); i++)
                    if(w.getPlayers().get(i).getPlace()!=null)
                        System.out.println("idx: " + i + " pos: " + w.getPlayers().get(i).getPlace().getX() + " " + w.getPlayers().get(i).getPlace().getY() + " points: " + w.getPlayers().get(i).getScore());
                    else
                        System.out.println("idx: " + i + " pos: dead  points: " + w.getPlayers().get(i).getScore());
                break;

            case "listboxes":
                for (int i=0; i<w.getBoxes().size(); i++)
                    System.out.println("idx: " + i + " pos: " + w.getBoxes().get(i).getPlace().getX() + " " + w.getBoxes().get(i).getPlace().getY());
                break;

            case "move":
                if (command.size() != 3)
                    System.out.println("Nem megfelelő paraméterek! helyesen: move <játékos száma> <up|down|left|right>");
                else {
                    int player = Integer.parseInt(command.get(1));
                    switch (command.get(2)) {
                        case "up":
                            w.getPlayer(player).move(Directions.top);
                            break;
                        case "left":
                            w.getPlayer(player).move(Directions.left);
                            break;
                        case "right":
                            w.getPlayer(player).move(Directions.right);
                            break;
                        case "down":
                            w.getPlayer(player).move(Directions.bottom);
                            break;
                    }
                }
                break;

            case "put":
                if (command.size() != 3)
                    System.out.println("Nem megfelelő paraméterek! helyesen: put <játékos száma> <honey|oil|clean>");
                else {
                    int player = Integer.parseInt(command.get(1));

                    if (command.get(2).equals("honey"))
                        w.getPlayer(player).applyFluid(Stickyness.Honey);
                    else if (command.get(2).equals("oil"))
                        w.getPlayer(player).applyFluid(Stickyness.Oil);
                    else if (command.get(2).equals("clean"))
                        w.getPlayer(player).applyFluid(Stickyness.Normal);
                }

                    break;

            case "load":
                break;

            case "save":
                if (command.size() == 1)
                    System.out.println("Hiányzó fájlnév!");
                else
                    save(command.get(1));
                break;
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

            for (int i = 0; i < w.getSwitches().size(); i++) {
                file.write( w.getSwitches().get(i).getHole().getX() + " ");
                file.write( w.getSwitches().get(i).getHole().getY() + "\n");
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generate(){
        if(command.get(1).equals("rnd")) w.generateMap();
        else if(command.size()<3) w.generateMap(Integer.parseInt(command.get(1)));
        else w.generateMap(Integer.parseInt(command.get(1)), Integer.parseInt(command.get(2)));
    }

    public void add(){
        int x = Integer.parseInt(command.get(2));
        int y = Integer.parseInt(command.get(3));
        if(w.getMap().get(x + y*w.getMapWidth()).getHolding() != null)
            System.out.println("A Cella már foglalt!");
        else {
            switch (command.get(1)) {
                case "b":
                    Box b = new Box();
                    b.setPlace(w.getMap().get(x + y*w.getMapWidth()));
                    w.getMap().get(x + y*w.getMapWidth()).setHolding(b);
                    w.addBox(b);
                    b.setWarehouse(w);
                    break;
                case "p":
                    Player p = new Player();
                    p.setPlace(w.getMap().get(x + y*w.getMapWidth()));
                    w.getMap().get(x + y*w.getMapWidth()).setHolding(p);
                    w.getPlayers().add(p);
                    p.setWarehouse(w);
                    break;
                default:
                    System.out.println("Rossz argumentum!");
                    break;
            }
        }
    }

    public void remove(){
        switch (command.get(1)){
            case "b":
                w.removeEntity(w.getBoxes().get(Integer.parseInt(command.get(2))));
                break;
            case "p":
                w.removeEntity(w.getPlayers().get(Integer.parseInt(command.get(2))));
                break;
            default:
                System.out.println("Rossz argumentum!");
                break;
        }
    }

    public void changecell(){
        int x = Integer.parseInt(command.get(2));
        int y = Integer.parseInt(command.get(3));
        int x2 = 0;
        int y2 = 0;
        if(command.size()>4) {
            x2 = Integer.parseInt(command.get(4));
            y2 = Integer.parseInt(command.get(5));
        }
        w.getMap().remove(x + y * w.getMapWidth());
        switch (command.get(1)){
            case "cell":
                w.getMap().add(x + y * w.getMapWidth(),new Cell());
                break;
            case "hole":
                w.getMap().add(x + y * w.getMapWidth(),new Hole());
                break;
            case "goal":
                w.getMap().add(x + y * w.getMapWidth(),new Goal());
                break;
            case "wall":
                w.getMap().add(x + y * w.getMapWidth(),new Wall());
                break;
            case "switch":
                w.getMap().remove(x2 + y2 * w.getMapWidth());
                SwitchableHole sh = new SwitchableHole();
                w.getMap().add(x2 + y2 * w.getMapWidth(), sh);
                linkCell(x2, y2);
                w.getMap().add(x + y * w.getMapWidth(),new Switch(sh));
                break;
            default:
                System.out.println("Rossz argumentum!");
                break;

        }
        linkCell(x, y);
    }

    public void linkCell(int x, int y){
        if(x != 0){
            w.getMap().get(x + y * w.getMapWidth()).setNeighbour(w.getMap().get(x - 1 + y * w.getMapWidth()), Directions.left);
            w.getMap().get(x - 1 + y * w.getMapWidth()).setNeighbour(w.getMap().get(x + y * w.getMapWidth()), Directions.right);
        }
        if(x != w.getMapWidth() - 1){
            w.getMap().get(x + y * w.getMapWidth()).setNeighbour(w.getMap().get(x + 1 + y * w.getMapWidth()), Directions.right);
            w.getMap().get(x + 1 + y * w.getMapWidth()).setNeighbour(w.getMap().get(x + y * w.getMapWidth()), Directions.left);
        }
        if(y != 0){
            w.getMap().get(x + y * w.getMapWidth()).setNeighbour(w.getMap().get(x  + (y - 1) * w.getMapWidth()), Directions.top);
            w.getMap().get(x + (y - 1) * w.getMapWidth()).setNeighbour(w.getMap().get(x  + y * w.getMapWidth()), Directions.bottom);
        }
        if(y != w.getMapHeight() - 1){
            w.getMap().get(x + y * w.getMapWidth()).setNeighbour(w.getMap().get(x + (y + 1) * w.getMapWidth()), Directions.bottom);
            w.getMap().get(x + (y + 1) * w.getMapWidth()).setNeighbour(w.getMap().get(x + y * w.getMapWidth()), Directions.top);
        }
    }
}