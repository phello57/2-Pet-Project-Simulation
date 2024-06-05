package DefaultClasses;

import GameClasses.Entity;
import java.util.LinkedHashSet;

public class Node {
    private int value;
    private Entity entity;
    private LinkedHashSet<Edge> edges;

    // нужна для поиска всех циклов в графе
    //private LinkedHashMap<Node, Edge> parents = new LinkedHashMap<>();


    public LinkedHashSet<Edge> getEdges() {return edges;}

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }
    public void removeEdge(Edge edge) {
        this.edges.add(edge);
    }

    public Entity getEntity() {return entity;}
    public void setEntity(Entity entity) {this.entity = entity;}

    public Node(int value) {
        this.edges = new LinkedHashSet<>();
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
