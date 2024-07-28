package game.model.game_entities;

import game.model.BFS.Node;
import game.view.Render;

public class Tree extends Entity {
    public Tree(Node node) {
        super(node);

        this.emoji = Render.EMOJI_TREE;


    }

}
