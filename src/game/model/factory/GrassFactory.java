package game.model.factory;

import game.model.BFS.Node;
import game.model.game_entities.Entity;
import game.model.game_entities.Grass;

public class GrassFactory implements EntityFactory{

    @Override
    public Entity createEntity(Node node) {
        return new Grass(node);
    }
}
