package game.Control;

import game.model.game_entities.*;

import java.util.Iterator;


public class Control extends Action {
    public Control(GameMap map) {
        super(map);
    }

    @Override
    public void initAction() {
        Action action = new CreateEntitiesAction(world);
        action.initAction();
    }

    public void turnActions() {
        int countPigs = 0;

        for (Iterator<Entity> iterator =
             world.getSetEntitiesWithHP().iterator(); iterator.hasNext(); )
        {
            Creature creature = (Creature) iterator.next();

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
            Action action = new CreateEntitiesAction(world);
            ((CreateEntitiesAction) action).addEntities();
        }
    }


}
