package fr.backtrack;

/**
 * A Pair contain a direction and position, used to return these two data in functions.
 * @author Safenein
 */
public class Pair {
    public Direction direction;
    public Position position;

    /**
     * Generate a new Pair with set direction and position
     * @param direction
     * @param position
     */
    public Pair(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    /**
     * Generate a copy of a Pair
     * @return clone
     */
    public Pair clone() {
        return new Pair(direction, position.clone());
    }
}
