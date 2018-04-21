package sokoban;

public enum Stickyness {
    Oil(0.5),
    Normal(1),
    Honey(2);

    private double value;

    Stickyness(double v) {
        value = v;
    }

    public double getValue(){
        return value;
    }
}
