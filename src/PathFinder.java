import java.util.*;

public class PathFinder {

    private Map map;

    public PathFinder(Map map) {
        this.map = map;
    }

    public List<Position> BFS(Entity entity) {
        List<Position> path = new ArrayList<>();
        Queue<Position> queue = new LinkedList<>();
        Set<Position> visitedСells = new HashSet<>();
        HashMap<Position, Position> cameFrom = new HashMap<>();
        queue.add(entity.getPosition());
        visitedСells.add(entity.getPosition());
        while (!queue.isEmpty()) {
            Position currposition = queue.poll();
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0)
                        continue;

                    int newX = currposition.getX() + dx;
                    int newY = currposition.getY() + dy;
                    Position newposition = new Position(newX, newY);


                    if (map.isWithinBounds(newposition) && !visitedСells.contains(newposition)) {
                        if (!(map.getEntityAt(newposition) instanceof Rock) && !(map.getEntityAt(newposition) instanceof Tree)) {
                            if (entity instanceof Herbivore && map.getEntityAt(newposition) instanceof Grass) {
                                cameFrom.put(newposition, currposition);
                                Position step = newposition;
                                while (step != null) {
                                    path.add(step);
                                    step = cameFrom.get(step);
                                }
                                Collections.reverse(path);
                                return path;
                            }
                            if (entity instanceof Predator && map.getEntityAt(newposition) instanceof Herbivore) {
                                cameFrom.put(newposition, currposition);
                                Position step = newposition;
                                while (step != null) {
                                    path.add(step);
                                    step = cameFrom.get(step);
                                }
                                Collections.reverse(path);
                                return path;
                            }
                            visitedСells.add(newposition);
                            queue.add(newposition);
                            cameFrom.put(newposition, currposition);

                        } else {
                            continue;
                        }

                    }
                }
            }
        }
        return new ArrayList<>();

    }

}
