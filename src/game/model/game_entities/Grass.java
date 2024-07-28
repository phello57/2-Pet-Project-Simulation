package game.model.game_entities;
import game.model.BFS.Node;
import game.Settings;
import game.view.Render;
public class Grass extends Creature{
    // должно быть множество: еда, из за хп
    public Grass(Node node) {
        super(node);
        this.hp = Settings.HP_GRASS;
        this.emoji = Render.EMOJI_GRASS;
    }
}
