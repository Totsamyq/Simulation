

    public class Renderer {


        public void Process(Map map) {
    //        System.out.print("\033[H\033[2J"); System.out.flush();
            for (int i = 0; i < map.getHeight(); i++) {
                for (int j = 0; j < map.getWidth(); j++) {
                    Position position = new Position(j, i);
                    if (!map.isCellFree(position)) {
                        if (map.getEntityAt(position) instanceof Predator) {
                            System.out.print("\uD83D\uDC3A");
                        }
                        if (map.getEntityAt(position) instanceof Herbivore) {
                            System.out.print("🦌");
                        }
                        if (map.getEntityAt(position) instanceof Grass) {
                            System.out.print("\uD83C\uDF3F");
                        }
                        if (map.getEntityAt(position) instanceof Tree) {
                            System.out.print("\uD83C\uDF33");
                        }
                        if (map.getEntityAt(position) instanceof Rock) {
                            System.out.print("🪨");
                        }

                    } else {
                        System.out.print("⬜");
                    }
                }
                System.out.println();
            }
        }

    }
