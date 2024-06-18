package MVC.model.game_entities;

import MVC.model.classes_for_bfs.Node;
import MVC.view.Render;

public class Tree extends Nature{
    public Tree(Node node) {
        super(node);

        this.setEmoji(Render.EMOJI_TREE);
    }
}
