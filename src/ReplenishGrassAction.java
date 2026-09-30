import java.util.Random;

public class ReplenishGrassAction extends Action {
    private int partWithGrass;

    public ReplenishGrassAction(int partWithGrass) {
        this.partWithGrass = partWithGrass;
    }

    @Override
    public void toPerform(Map map, PathFinder pathFinder) {


        if (this.partWithGrass > map.getGrassCount()) {
            while (this.partWithGrass > map.getGrassCount()) {
                Random random = new Random();
                int x = random.nextInt(map.getWidth());
                int y = random.nextInt(map.getHeight());
                Position position = new Position(x, y);
                if (map.isCellFree(position)) {
                    Grass grass = new Grass(x, y);
                    map.addEntity(grass);
                } else continue;

            }
        }
    }
}
