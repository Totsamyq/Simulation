import java.util.ArrayList;
import java.util.List;

public class Herbivore extends Creature{

    public Herbivore(int x, int y, int hp, int speed){
        super(x, y, "🦌", hp, speed);
    }

    public boolean takeDamage(int attackPower) {
        int newhp = this.getHp() - attackPower;
        if (newhp > 0) {
            this.setHp(newhp);
            return false;
        }
        return true;
    }
    @Override
        public void makeMove(Map map, PathFinder pathFinder){
        List<Position> listposition = new ArrayList();
        listposition = pathFinder.BFS(this);
        if(!listposition.isEmpty()){

                if (listposition.size() == 2) {
                    if(map.getEntityAt(listposition.get(1)) instanceof Grass) {
                        Entity grass = map.getEntityAt(listposition.get(1));
                        map.removeEntity(grass);

                    }
                } else {
                  map.moveEntity( this , listposition.get(1));
                  
                }

        }

    }
}
    