package fr.pathfinder.backtrack;
/**
 * @author Safenein
 */
public class Position {
    public int x;
    public int y;

    /**
     * Create object that contains coordinate in 2D Euclidean map
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Create copy of this object
     * @return clone
     */
    public Position clone() {
        return new Position(x, y);
    }
}
