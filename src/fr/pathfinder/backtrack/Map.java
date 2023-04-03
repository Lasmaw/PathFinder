package fr.pathfinder.backtrack;
import java.util.Random;

/**
 * A Map is an object that contains the height of a terrain
 * @author Safenein
 */
public class Map {
    final public int[][] heightMap;
    final public int height;
    final public int width;

    /**
     * Generate a new map
     * @param width
     * @param height
     */
    public Map(int width, int height) {
        this.heightMap = new int[height][width];
        this.height = height;
        this.width = width;
    }

    /**
     * Generate a valid map from table of int
     * @param heightMap
     */
    public Map(int[][] heightMap) {
        this.heightMap = heightMap;
        this.height = heightMap.length;
        this.width = heightMap[0].length;
    }

    /**
     * Randomize each cell of map from 0 to max_height
     * @param max_height
     * @return this
     */
    public Map randomize(int max_height) {
        Random random = new Random();
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j < heightMap[0].length; j++) {
                heightMap[i][j] = random.nextInt(max_height);
            }
        }
        return this;
    }

    /**
     * Set the cell to value at coordinate i,j
     * @param i
     * @param j
     * @param value
     */
    public void set(int i, int j, int value) {
        heightMap[i][j] = value;
    }

    public void set(Position position, int value) {
        set(position.x, position.y, value);
    }

    public int getHeightDelta(Position origin, Position destination) {
        return heightMap[destination.x][destination.y]
                - heightMap[origin.x][origin.y];
    }
}
