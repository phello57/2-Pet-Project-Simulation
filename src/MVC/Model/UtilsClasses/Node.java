package MVC.Model.UtilsClasses;

import MVC.Model.GameClasses.Entity;
import MVC.Model.Model;

import java.util.LinkedHashSet;

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
            return Model.getEmojiVoid();
        }
        return this.getEntity().getEmoji();
    }
}
