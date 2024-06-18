package MVC.model.classes_for_bfs;

import MVC.model.game_entities.Entity;

import java.util.LinkedHashSet;
import MVC.view.Render;
public class Node {

    private Entity entity;
    private final LinkedHashSet<Edge> edges;


    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public LinkedHashSet<Edge> getEdges() {
        return edges;
    }

    public Entity getEntity() {return entity;}
    public void setEntity(Entity entity) {this.entity = entity;}

    public Node() {
        this.edges = new LinkedHashSet<>();
    }
    @Override
    public String toString() {
        if (this.getEntity() == null) {
            return Render.EMOJI_VOID;
        }
        return this.getEntity().getEmoji();
    }
}
