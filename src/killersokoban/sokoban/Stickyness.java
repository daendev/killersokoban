package killersokoban.sokoban;

import killersokoban.test.Test;

public enum Stickyness {
    Oil(0.1),
    Normal(1),
    Honey(5);

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
