import java.util.List;


public class Simulation {

    private Map map;
    private PathFinder pathFinder;
    private List<Action> initAction;
    private List<Action> turnAction;
    private Renderer renderer;
    private int stepcounter = 0;
    private boolean running = false;

    public Simulation(Map map, List<Action> initAction, List<Action> turnAction, Renderer renderer, PathFinder pathFinder) {
        this.map = map;
        this.initAction = initAction;
        this.turnAction = turnAction;
        this.renderer = renderer;
        this.pathFinder = pathFinder;
    }

    public void nextTurn() {

        for (int i = 0; i < turnAction.size(); i++) {
            turnAction.get(i).toPerform(map, pathFinder);
        }
        renderer.Process(map);
    }

    public void pauseSimulation() throws InterruptedException {
        running = false;
    }

    public void startSimulation() throws InterruptedException {
        for (int i = 0; i < initAction.size(); i++) {
            initAction.get(i).toPerform(map, pathFinder);
        }
        running = true;
        while (running) {
            nextTurn();
            Thread.sleep(2000);
            System.out.println(stepcounter++);

        }
    }


}
