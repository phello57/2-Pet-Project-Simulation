package MVC.Model.GameClasses;
import MVC.Model.UtilsClasses.Node;
import MVC.Settings;

public class Grass extends Entity{

    public Grass(Node node) {
        super(node);
        this.setHp(Settings.HP_GRASS);
        this.setEmoji(Settings.EMOJI_GRASS);
    }
}
