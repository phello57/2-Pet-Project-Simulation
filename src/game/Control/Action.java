package game.Control;

import game.model.game_entities.GameMap;

public abstract class Action {
    protected GameMap world;

    public Action(GameMap map) { this.world = map;}
    public abstract void initAction();
}
