package MVC.model.game_entities;
import MVC.model.classes_for_bfs.Node;
import MVC.view.Render;
public class Rock extends Nature{
    public Rock(Node node) {
        super(node);
        this.setEmoji(Render.EMOJI_ROCK);
    }

}
