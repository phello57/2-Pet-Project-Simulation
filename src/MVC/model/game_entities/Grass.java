package MVC.model.game_entities;
import MVC.model.classes_for_bfs.Node;
import MVC.Settings;
import MVC.view.Render;
public class Grass extends Creature{
    // должно быть множество: еда, из за хп
    public Grass(Node node) {
        super(node);
        this.setHp(Settings.HP_GRASS);
        this.setEmoji(Render.EMOJI_GRASS);
    }
}
