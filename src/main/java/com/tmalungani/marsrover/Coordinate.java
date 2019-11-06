package com.tmalungani.marsrover;

public class Coordinate {

    private final int x;
    private final int y;

    /**
     * Initialise the coordinates
     *
     * @param int x
     * @param int y
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y coordinate
     *
     * @return
     */
    public int getY() {
        return y;
    }
}
