package game.model.factory;

import game.model.BFS.Node;
import game.model.game_entities.Entity;

public interface EntityFactory {

    Entity createEntity(Node node);
}
