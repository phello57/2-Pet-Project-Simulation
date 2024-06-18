package MVC.Controller;

import MVC.model.game_entities.*;
import MVC.Settings;
import java.util.Iterator;


public class Actions {

    public static void initActions(GameMap pMap) {
        CreateEntities.createEntities(pMap, Settings.SPAWN_BEAR, Settings.SPAWN_ROCK, Settings.SPAWN_PIG, Settings.SPAWN_TREE, Settings.SPAWN_GRASS);
    }

    public static void turnActions(GameMap pMap) {
        int countPigs = 0;

        for (Iterator<Entity> iterator =
             pMap.getSetAllEntities().iterator(); iterator.hasNext(); )
        {
            Creature creature = (Creature)iterator.next();

            if (creature.getHp() <= 0 ) {
                iterator.remove();
                creature.getCurNode().setEntity(null);
                continue;
            }

            if (!creature.getArrGoals().isEmpty()) {
                creature.makeMove();
            }
            if ("Pig".equals(creature.getClass().getSimpleName())) {
                countPigs += 1;
            }
        }

        if (countPigs == 0 ) {
            CreateEntities.addEntities(pMap);
        }
    }
}
