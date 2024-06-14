package MVC.Model.GameClasses;
import MVC.Model.UtilsClasses.Node;
import MVC.Settings;

public class Rock extends Entity{
    public Rock(Node node) {
        super(node);
        this.setEmoji(Settings.EMOJI_ROCK);
    }

}
