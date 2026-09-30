import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Map {

    private HashMap<Position, Entity> worldMap = new HashMap<Position, Entity>();
    private LinkedList<Predator> predatorList = new LinkedList<Predator>();
    private LinkedList<Herbivore> herbivoreList = new LinkedList<Herbivore>();
    private LinkedList<Grass> grassList = new LinkedList<>();
    private int height;
    private int width;


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public List<Herbivore> getHerbivore() {
        return Collections.unmodifiableList(herbivoreList);
    }

    public List<Predator> getPredator() {
        return Collections.unmodifiableList(predatorList);
    }

    public  int getGrassCount() {
        return grassList.size();
    }

    public boolean isCellFree(Position position) {
        if (worldMap.containsKey(position)) {
            return false;
        }
        return true;
    }

    public boolean isWithinBounds(Position position) {
        if (position.getX() < 0 || position.getX() >= width || position.getY() < 0 || position.getY() >= height)
            return false;//за пределами карты
        else
            return true;
    }

    public boolean addEntity(Entity entity) {
        if (isCellFree(entity.getPosition()) && isWithinBounds(entity.getPosition())) {
            worldMap.put(entity.getPosition(), entity);
            if (entity instanceof Herbivore) {
                herbivoreList.add((Herbivore) entity);
            } else if (entity instanceof Predator) {
                predatorList.add((Predator) entity);
            } else if (entity instanceof Grass) {
                grassList.add((Grass) entity);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean removeEntity(Entity entity) {
        if (!isCellFree(entity.getPosition()) && isWithinBounds(entity.getPosition())) {
            worldMap.remove(entity.getPosition(), entity);
            if (entity instanceof Herbivore) {
                herbivoreList.remove((Herbivore) entity);
            } else if (entity instanceof Predator) {
                predatorList.remove((Predator) entity);
            } else if (entity instanceof Grass) {
                grassList.remove((Grass) entity);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean moveEntity(Entity entity, Position newposition) {
        if (!isCellFree(entity.getPosition()) && isWithinBounds(entity.getPosition())) {
            if (isCellFree(newposition) && isWithinBounds(newposition)) {
                worldMap.remove(entity.getPosition(), entity);
                worldMap.put(newposition, entity);
                entity.setPosition(newposition);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Entity getEntityAt(Position position) {
        return worldMap.get(position);
    }

}
