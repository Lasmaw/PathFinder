package fr.backtrack;

import java.util.ArrayList;

/**
 * A stack is an object that behave like a LIFO memory, it contains at each level the current position and next direction
 * @author Safenein
 */
public class Stack {
    public final ArrayList<Pair> dataStack = new ArrayList<>();
    private int score = 0;

    /**
     * Push onto the stack direction and nextPosition
     * @param direction
     * @param nextPosition
     * @return lastElement
     */
    public Pair push(Direction direction, Position nextPosition) {
        dataStack.get(0).direction = direction;
        dataStack.add(0, new Pair(Direction.values()[0], nextPosition));
        return dataStack.get(0);
    }

    /**
     * Delete lastElement
     * @return newLastElement
     */
    public Pair pop() {
        dataStack.remove(0);
        return dataStack.get(0);
    }

    /**
     * Get the lastElement
     * @return lastElement
     */
    public Pair getLast() {
        return this.dataStack.get(0);
    }

    /**
     * Return the size of stack
     * @return size
     */
    public int getSize() {
        return dataStack.size();
    }

    /**
     * Get the i th element
     * @param i
     * @return i_Element
     */
    public Pair get(int i) {
        return dataStack.get(i);
    }

    /**
     * Method used for the copy of the stack
     * @param element
     */
    private void add(Pair element) {
        dataStack.add(element);
    }

    /**
     * Check if you already got to this cell
     * @param position
     * @return true if known cell
     */
    public boolean checkIfKnownCell(Position position) {
        for (Pair cursor : dataStack)
            if (cursor.position.x == position.x && cursor.position.y == position.y)
                return true;
        return false;
    }

    /**
     * Initialize new stack
     * @param start
     */
    public Stack(Position start) {
        dataStack.add(new Pair(Direction.START, start));
    }

    /**
     * Generate empty stack for copy
     */
    private Stack() {

    }

    /**
     * Generate a copy of the stack
     * @return clone
     */
    public Stack clone() {
        Stack clone = new Stack();
        for (Pair element : dataStack)
            clone.add(element.clone());
        return clone;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int i) {
        score += i;
    }
}
