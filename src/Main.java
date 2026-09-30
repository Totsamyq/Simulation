void main() throws InterruptedException {


    Map map = new Map(15, 40);
    PathFinder pathFinder = new PathFinder(map);
    Renderer renderer = new Renderer();
    List<Action> initAction = new ArrayList<>();
    PopulateMapAction populateMapAction = new PopulateMapAction(50, 120, 30, 30, 200);
    initAction.add(populateMapAction);
    List<Action> turnAction = new ArrayList<>();
    MoveCreaturesAction moveCreaturesAction = new MoveCreaturesAction();
    ReplenishGrassAction replenishGrassAction = new ReplenishGrassAction(60);
    turnAction.add(moveCreaturesAction);
    turnAction.add(replenishGrassAction);

    Simulation simulation = new Simulation(map, initAction, turnAction, renderer, pathFinder);
    simulation.startSimulation();


}
