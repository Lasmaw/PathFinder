package fr.pathfinder.backtrack;

/**
 * BackTracker is an object that take a map in input and output the best path from one point to another
 * @author Safenein
 */
public class BackTracker {
    final private Map map;
    private Stack stack = null;
    private int bestScore = 0;
    private Stack bestStack = null;

    /**
     * map is the map attached to the BackTracker
     * @param map
     */
    public BackTracker(Map map) {
        this.map = map;
    }

    /**
     * After resolve(), contain the best path in a stack
     * @return clone of the bestStack
     */
    public Stack getStack() {
        return bestStack.clone();
    }

    /**
     * Take a cursor as input and return the next position if the cursor is applied
     * @param cursor
     * @return next position
     */
    private Position getNextPos(Pair cursor) {
        Position nextPosition = new Position(cursor.position.x, cursor.position.y);

        switch (cursor.direction) {
            case D_LEFT:
            case LEFT:
            case UP_LEFT:
                nextPosition.x -= 1;
                break;
            case UP_RIGHT:
            case RIGHT:
            case D_RIGHT:
                nextPosition.x += 1;
                break;
            default:
        }
        switch (cursor.direction) {
            case UP_LEFT:
            case UP:
            case UP_RIGHT:
                nextPosition.y += 1;
                break;
            case D_LEFT:
            case DOWN:
            case D_RIGHT:
                nextPosition.y -= 1;
                break;
            default:
        }

        return nextPosition;
    }

    /**
     * Take a cursor as input, check if cursor effect is applicable, return next cursor and save effect if possible
     * @param cursor
     * @return next cursor
     */
    public Pair forward(Pair cursor) {
        if (cursor.direction == Direction.END) {
            Pair nextCursor = stack.pop(); // Delete last value in stack and return the new last value
            nextCursor.direction = Direction.values()[nextCursor.direction.ordinal() + 1]; // direction++
            return nextCursor;
        }

        Position nextPosition = getNextPos(cursor);
        if (nextPosition.x < 1 || nextPosition.y < 0
                || nextPosition.x >= map.width || nextPosition.y >= map.height // Check bounds
                || map.getHeightDelta(cursor.position, nextPosition) > 3
                || stack.checkIfKnownCell(nextPosition))
        {
            return new Pair(Direction.values()[cursor.direction.ordinal() + 1], cursor.position);
            // return cursor with cursor.direction++
        }

        return stack.push(cursor.direction, nextPosition).clone();
        // add cursor to stack and generate new cursor, new cursor has direction=LEFT by default
    }

    /**
     * Negate the previous effect as if it was inapplicable
     * @return corrected previous cursor
     */
    public Pair skip() {
        Pair nextCursor = stack.pop();

        nextCursor.direction = Direction.values()[nextCursor.direction.ordinal() + 1];
        return nextCursor;
    }

    /**
     * Save the current cursor as the best one and keep it away
     */
    public void saveBest() {
        int score = 0;
        for (int i = 0; i < stack.getSize() - 1; i++) {
            int delta = map.getHeightDelta(stack.get(i).position, stack.get(i + 1).position);
            if (delta > 0) {
                score += delta;
            }
        }
        if (score < bestScore || bestStack == null) {
            bestScore = score;
            bestStack = stack.clone();
        } else if (score == bestScore && bestStack.getSize() > stack.getSize()) {
            bestStack = stack.clone();
        }
    }

    /**
     * Find the best path between to points on a map
     * @param start
     * @param end
     * @return bestStack
     * @throws Exception
     */
    public Stack resolve(Position start, Position end) throws Exception {
        if (start.x >= map.width || start.y >= map.height || end.x >= map.width || end.y >= map.height)
            throw new Exception("Invalid coordinates!");

        stack = new Stack(start);

        Pair cursor = new Pair(Direction.LEFT, start); // contain the current position and next direction

        while (cursor.position.x != start.x || cursor.position.y != start.y || cursor.direction != Direction.END) {
            // while we are not at the beginning and can go somewhere

            cursor = forward(cursor);

            if (cursor.position.x == end.x && cursor.position.y == end.y) {
                saveBest();
                cursor = skip(); // pretend that solution doesn't exist and go backward to test another
            }
        }

        if (bestStack == null)
            throw new Exception("Impossible to find a path!");

        return bestStack;
    }
}
