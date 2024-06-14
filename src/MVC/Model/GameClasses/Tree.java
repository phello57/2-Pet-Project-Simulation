package MVC.Model.GameClasses;

import MVC.Model.UtilsClasses.Node;
import MVC.Settings;

public class Tree extends Entity{
    public Tree(Node node) {
        super(node);

        this.setEmoji(Settings.EMOJI_TREE);
    }
}
