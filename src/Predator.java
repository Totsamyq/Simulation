import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Predator extends Creature {

    private int attackPower;

    public int getAttackPower() {
        return attackPower;
    }

    public Predator(int x, int y, int hp, int speed, int attackPower) {
        super(x, y, "\uD83D\uDC3A", hp, speed);
        this.attackPower = attackPower;
    }





    @Override
    public void makeMove(Map map, PathFinder pathFinder) {
        List<Position> listposition = new ArrayList();
        listposition = pathFinder.BFS(this);
        if (!listposition.isEmpty())
            if (listposition.size() == 2) {
                if (map.getEntityAt(listposition.get(1)) instanceof Herbivore) {

                    Herbivore victim = (Herbivore) map.getEntityAt(listposition.get(1));
                    boolean died = victim.takeDamage(this.getAttackPower());
                    if(died){
                        Entity herbivore = map.getEntityAt(listposition.get(1));
                        map.removeEntity(herbivore);
                    }



                }
            } else {
                map.moveEntity(this, listposition.get(1));
            }
    }
}

