public abstract class Entity {

    //    private int x;
//    private int y;
    private Position position;
    private String appearance;

    public Position getPosition() {
        return position;
    }
    void setPosition(Position position){
        this.position = position;
    }
//    public int getX(){
//          return x;
//    }
//    public void setX(int x){
//        this.x = x;
//    }
//
//    public int getY(){
//        return y;
//    }
//    public void setY(int y){
//        this.y = y;
//    }

    public String getAppearance() {
        return appearance;
    }


    public Entity(Position position, String appearance) {
        this.position = position;
        this.appearance = appearance;
    }
}
