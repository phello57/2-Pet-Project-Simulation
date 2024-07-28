package game.model.factory;

import game.model.game_entities.Entity;
import game.model.game_entities.Rock;
import game.model.BFS.Node;

public class RockFactory implements EntityFactory{

    @Override
    public Entity createEntity(Node node) {
        return new Rock(node);
    }
}
