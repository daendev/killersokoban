package test;
import sokoban.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
public class Test {

    private List<String> command;
    private Warehouse w;
    private boolean file;
    private FileWriter fw;
    public static Logger logger = new Logger();

    public void setFile(boolean file) {
        this.file = file;
    }

    public void setFw(FileWriter fw) {
        this.fw = fw;
    }

    public Test(Warehouse w) {
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

//        for (int i = 0; i < command.size(); i++) {
//            System.out.println(command.get(i));
//        }
    }

    public boolean executeCommand(){
        switch (command.get(0)) {
            case "generate":
                if (command.size() < 2)
                    System.out.println("Túl kevés argumentum!");
                else {
                    w.wipe();
                    generate();
                }
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
                if(file) {
                    try {
                        w.draw(fw);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else
                    w.draw();
                break;

            case "listplayers":
                if(file)
                    listplayers(fw);
                else
                    listplayers();
                break;

            case "listboxes":
                if(file)
                    listboxes(fw);
                else
                    listboxes();
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

                if (w.endGame()) return true;
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
                if (command.size() == 1)
                    System.out.println("Hiányzó fájlnév!");
                else
                    load(command.get(1));
                break;

            case "save":
                if (command.size() == 1)
                    System.out.println("Hiányzó fájlnév!");
                else
                    save(command.get(1));
                break;
            case "exit":
                return true;
            default:
                System.out.println("Hibás parancs!");
        }
        return false;
    }

    public void load(String fileName){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> read = Arrays.asList(bufferedReader.readLine().split(" "));
            int width = Integer.parseInt(read.get(0));
            int height = Integer.parseInt(read.get(1));
            int switchNum = 0;
            w.wipe();
            for (int i = 0; i < height; i++) {
                String row = bufferedReader.readLine();
                for (int j=0; j<row.length(); j++){
                    switch (row.charAt(j)){
                        case 'W':
                            w.getMap().add(new Wall());
                                    break;
                        case '-':
                            w.getMap().add(new Cell());
                            break;
                        case 'B':
                            w.getMap().add(new Cell());
                            break;
                        case 'S':
                            w.getSwitches().add(new Switch(new SwitchableHole()));
                            w.getMap().add(w.getSwitches().get(switchNum++));
                            break;
                        case 'H':
                            w.getMap().add(new Hole());
                            break;
                        case 'G':
                            w.getMap().add(new Goal());
                            break;
                        case 'P':
                            w.getMap().add(new Cell());
                            break;
                    }

                }
            }


            int playerNum = Integer.parseInt(bufferedReader.readLine());
            for (int i=0; i<playerNum; i++) {
                read = Arrays.asList(bufferedReader.readLine().split(" "));
                int x = Integer.parseInt(read.get(0));
                int y = Integer.parseInt(read.get(1));
                w.getPlayers().add(new Player());
                w.getPlayers().get(i).setWarehouse(w);
                w.getPlayers().get(i).setPlace(w.getMap().get(x + y*width));
                w.getMap().get(x + y*width).setHolding(w.getPlayers().get(i));
            }

            int boxNum = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < boxNum; i++) {
                read = Arrays.asList(bufferedReader.readLine().split(" "));
                int x = Integer.parseInt(read.get(0));
                int y = Integer.parseInt(read.get(1));
                w.getBoxes().add(new Box());
                w.getBoxes().get(i).setWarehouse(w);
                w.getBoxes().get(i).setPlace(w.getMap().get(x + y*width));
                w.getMap().get(x + y*width).setHolding(w.getBoxes().get(i));
            }

            for (int i = 0; i < switchNum; i++) {
                read = Arrays.asList(bufferedReader.readLine().split(" "));
                int x = Integer.parseInt(read.get(0));
                int y = Integer.parseInt(read.get(1));
                w.getSwitches().get(i).setWarehouse(w);
                SwitchableHole sh = new SwitchableHole();
                if (w.getMap().get(x + y*width).getHolding() != null) {
                    sh.setHolding(w.getMap().get(x + y * width).getHolding());
                    sh.getHolding().setPlace(sh);
                }
                w.getMap().remove(x + y*width);
                w.getMap().add(x + y*width, sh);
                w.getSwitches().get(i).setHole((SwitchableHole) w.getMap().get(x + y*width));
            }

            for (int i = 0; i<width; i++){
                for(int j = 0; j<height; j++){
                    w.getMap().get(i + j * width).setWarehouse(w);
                    if(j!=0)
                        w.getMap().get(i + j * width).setNeighbour(w.getMap().get(i + (j-1) * width), Directions.top);
                    if(j!=height-1)
                        w.getMap().get(i + j * width).setNeighbour(w.getMap().get(i + (j+1) * width), Directions.bottom);
                    if(i!=0)
                        w.getMap().get(i + j * width).setNeighbour(w.getMap().get(i - 1 + j * width), Directions.left);
                    if(i!=width-1)
                        w.getMap().get(i + j * width).setNeighbour(w.getMap().get(i +1 + j * width), Directions.right);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void save(String fileName){
        try {
            FileWriter file = new FileWriter(fileName);
            file.write(w.getMapWidth() + " " + w.getMapHeight() + "\n");
            w.drawForSave(file);
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
                w.getBoxes().get(Integer.parseInt(command.get(2))).getPlace().removeEntity();
                w.getBoxes().get(Integer.parseInt(command.get(2))).setPlace(null);
                w.removeEntity(w.getBoxes().get(Integer.parseInt(command.get(2))));
                break;
            case "p":
                w.getPlayers().get(Integer.parseInt(command.get(2))).getPlace().removeEntity();
                w.getPlayers().get(Integer.parseInt(command.get(2))).setPlace(null);
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
                w.linkCell(x2, y2);
                Switch s = new Switch(sh);
                w.getMap().add(x + y * w.getMapWidth(),s);
                w.getSwitches().add(s);
                break;
            default:
                System.out.println("Rossz argumentum!");
                break;

        }
        w.linkCell(x, y);
    }


    public void listplayers(){
        for (int i=0; i<w.getPlayers().size(); i++)
            if(w.getPlayers().get(i).getPlace()!=null)
                System.out.println("idx: " + i + " pos: " + w.getPlayers().get(i).getPlace().getX() + " " + w.getPlayers().get(i).getPlace().getY() + " points: " + w.getPlayers().get(i).getScore());
            else
                System.out.println("idx: " + i + " pos: dead  points: " + w.getPlayers().get(i).getScore());
    }

    public void listplayers(FileWriter fw){
        try {
            for (int i = 0; i < w.getPlayers().size(); i++)
                if (w.getPlayers().get(i).getPlace() != null)
                    fw.write("idx: " + i + " pos: " + w.getPlayers().get(i).getPlace().getX() + " " + w.getPlayers().get(i).getPlace().getY() + " points: " + w.getPlayers().get(i).getScore() + "\n");
                else
                    fw.write("idx: " + i + " pos: dead  points: " + w.getPlayers().get(i).getScore()+"\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void listboxes(){
        for (int i=0; i<w.getBoxes().size(); i++)
            System.out.println("idx: " + i + " pos: " + w.getBoxes().get(i).getPlace().getX() + " " + w.getBoxes().get(i).getPlace().getY());
    }

    public void listboxes(FileWriter fw){
        try {
            for (int i = 0; i < w.getBoxes().size(); i++)
                fw.write("idx: " + i + " pos: " + w.getBoxes().get(i).getPlace().getX() + " " + w.getBoxes().get(i).getPlace().getY() + "\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}