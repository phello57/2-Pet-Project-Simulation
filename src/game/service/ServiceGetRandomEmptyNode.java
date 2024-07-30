package game.service;

import game.model.BFS.Node;
import game.model.game_entities.GameMap;

public class ServiceGetRandomEmptyNode {
    public static Node get(GameMap world) {
        int w;
        int l;
        while (true) {
            w = (int) (Math.random() * world.MAP_WIDTH);
            l = (int) (Math.random() * world.MAP_LENGTH);

            if (world.getNodeOnCoordinate(w, l).getEntity() == null) {
                break;
            }
        }
        return world.getNodeOnCoordinate(w, l);
    }
}
