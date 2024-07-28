package game.model.game_entities;
import game.model.BFS.Node;
import game.view.Render;
public class Rock extends Entity {
    public Rock(Node node) {
        super(node);
        this.emoji = Render.EMOJI_ROCK;
    }

}
