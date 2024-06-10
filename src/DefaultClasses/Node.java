package DefaultClasses;

import GameClasses.Entity;
import Utils.Settings;

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
            return Settings.getEmojiVoid();
        }
        return this.getEntity().getEmoji();
    }
}
