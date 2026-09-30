import java.util.ArrayList;
import java.util.List;

public class MoveCreaturesAction extends Action {

    @Override
    public void toPerform(Map map, PathFinder pathFinder) {


        List<Herbivore> herbivoreListCopy = new ArrayList<>(map.getHerbivore());

        List<Predator> predatorListCopy = new ArrayList<>(map.getPredator());
        for (int i = 0; i < herbivoreListCopy.size(); i++) {
            herbivoreListCopy.get(i).makeMove(map, pathFinder);
        }
        for (int i = 0; i < predatorListCopy.size(); i++) {
            predatorListCopy.get(i).makeMove(map, pathFinder);
        }
    }
}
