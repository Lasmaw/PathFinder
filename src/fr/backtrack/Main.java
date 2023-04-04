package fr.backtrack;

public class Main {
    public static void main(String[] args) {
        Map my_map = new Map(20, 20);
        my_map.randomize(10);

        BackTracker backTracker = new BackTracker(my_map);

        try {
            Stack solvedStack = backTracker.resolve(new Position(19,0), new Position(0,19));

            Map solvedMap = new Map(my_map.width, my_map.height);
            for (int i = 0; i < solvedMap.height * solvedMap.width; i++) {
                solvedMap.set(i/ my_map.height, i% my_map.width, 9);
            }
            for (int i = 0; i < solvedStack.getSize(); i++) {
                solvedMap.set(solvedStack.get(i).position, solvedStack.get(i).direction.ordinal());
            }

            for (int i = 0; i < my_map.height; i++) {
                for (int j = 0; j < my_map.width; j++) {
                    System.out.print(my_map.heightMap[i][j]);
                }
                System.out.println();
            }

            System.out.println();

            for (int i = 0; i < solvedMap.height; i++) {
                for (int j = 0; j < solvedMap.width; j++) {
                    System.out.print(solvedMap.heightMap[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }

    }
}
