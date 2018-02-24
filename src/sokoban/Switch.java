package sokoban;

public class Switch extends Cell {
    private SwitchableHole hole;



    public void change(){
        hole.setOpen(!hole.isOpen());
    }
}
