public abstract class Creature extends Entity{

    private int hp;
    private int speed;


    public int getHp() {
        return hp;
    }
    protected void setHp(int hp){
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }
    protected void setSpeed(int speed){
        this.speed = speed;
    }


    public Creature(int x, int y, String appearance, int hp, int speed){
        super(new Position(x,y), appearance);
        this.hp = hp;
        this.speed = speed;
    }

    public abstract void makeMove(Map map,PathFinder pathFinder);

}
