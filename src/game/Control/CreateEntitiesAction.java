package game.Control;

import game.Settings;
import game.model.BFS.Node;
import game.model.factory.*;
import game.model.game_entities.*;
import game.service.*;

public class CreateEntitiesAction extends Action {
    public CreateEntitiesAction(GameMap map) {
        super(map);
    }

    @Override
    public void initAction() {
        createEntities(Settings.SPAWN_BEAR,  new BearFactory());
        createEntities(Settings.SPAWN_ROCK, new RockFactory());
        createEntities(Settings.SPAWN_PIG, new PigFactory());
        createEntities(Settings.SPAWN_TREE, new TreeFactory());
        createEntities(Settings.SPAWN_GRASS, new GrassFactory());
    }

    public void createEntities(int count, EntityFactory factory) {

        int countEntities = count;
        for (; countEntities != 0; countEntities--) {
            Node emptyNode = ServiceGetRandomEmptyNode.get(world);
            world.addToMapEntity(factory.createEntity(emptyNode), emptyNode);
        }

    }

    public void addEntities() {
        createEntities(15, new GrassFactory());
        createEntities(5, new PigFactory());
    }
}
