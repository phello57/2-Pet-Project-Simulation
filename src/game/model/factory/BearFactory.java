package game.model.factory;

import game.model.BFS.Node;
import game.model.game_entities.Bear;
import game.model.game_entities.Entity;

public class BearFactory implements EntityFactory{

    @Override
    public Entity createEntity(Node node) {
        return new Bear(node);
    }
}
