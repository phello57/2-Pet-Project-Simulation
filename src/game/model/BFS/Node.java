package game.model.BFS;

import game.model.game_entities.Entity;

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

}
