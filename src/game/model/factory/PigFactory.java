package game.model.factory;

import game.model.BFS.Node;
import game.model.game_entities.Entity;
import game.model.game_entities.Pig;

public class PigFactory implements EntityFactory{

    @Override
    public Entity createEntity(Node node) {
        return new Pig(node);
    }


}
