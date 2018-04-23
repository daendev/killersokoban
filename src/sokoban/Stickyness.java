package sokoban;

import test.Test;

public enum Stickyness {
    Oil(0.5),
    Normal(1),
    Honey(2);

    private double value;

    Stickyness(double v) {
        Test.logger.w("Stickyness.constructor(double)");
        value = v;
    }

    public double getValue(){
        Test.logger.w("Stickyness.getValue()");
        return value;
    }
}
