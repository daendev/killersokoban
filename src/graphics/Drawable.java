package graphics;

import graphics.mapelements.ObjectGraphics;

/**
 * Kirajzolható játékelemek interfésze.
 */
public interface Drawable {

    /**
     * @return A létrehozott grafika.
     * A grafika létrehozása.
     */
    ObjectGraphics createGraphics();

}
