import java.util.Random;

public class PopulateMapAction extends Action {
    private int predatornum;
    private int herbivorenum;
    private int rocknum;
    private int treenum;
    private int grassnum;

    public PopulateMapAction(int predatornum, int herbivorenum, int rocknum, int treenum, int grassnum) {
        this.predatornum = predatornum;
        this.herbivorenum = herbivorenum;
        this.rocknum = rocknum;
        this.treenum = treenum;
        this.grassnum = grassnum;
    }

    @Override
    public void toPerform(Map map, PathFinder pathFinder) {
        Random random = new Random();

        int i = 0;
        while (i < predatornum) {
            int x = random.nextInt(map.getWidth());
            int y = random.nextInt(map.getHeight());
            Position position = new Position(x, y);
            if (map.isCellFree(position)) {
                Predator predator = new Predator(x, y, 100, 1, 35);
                map.addEntity(predator);
            } else continue;
            i++;
        }

        i = 0;
        while (i < herbivorenum) {
            int x = random.nextInt(map.getWidth());
            int y = random.nextInt(map.getHeight());
            Position position = new Position(x, y);
            if (map.isCellFree(position)) {
                Herbivore herbivore = new Herbivore(x, y, 100, 1);
                map.addEntity(herbivore);
            } else continue;
            i++;

        }

        i = 0;
        while (i < rocknum) {
            int x = random.nextInt(map.getWidth());
            int y = random.nextInt(map.getHeight());
            Position position = new Position(x, y);
            if (map.isCellFree(position)) {
                Rock rock = new Rock(x, y);
                map.addEntity(rock);

            } else continue;
            i++;

        }

        i = 0;
        while (i < treenum) {
            int x = random.nextInt(map.getWidth());
            int y = random.nextInt(map.getHeight());
            Position position = new Position(x, y);
            if (map.isCellFree(position)) {
                Tree tree = new Tree(x, y);
                map.addEntity(tree);

            } else continue;
            i++;

        }

        i = 0;
        while (i < grassnum) {
            int x = random.nextInt(map.getWidth());
            int y = random.nextInt(map.getHeight());
            Position position = new Position(x, y);
            if (map.isCellFree(position)) {
                Grass grass = new Grass(x, y);
                map.addEntity(grass);

            } else continue;
            i++;

        }
    }


}
