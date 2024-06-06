package DefaultClasses;

import GameClasses.Entity;
import java.util.LinkedHashSet;

public class Node {
    private byte x;
    private byte y;

    public int getX() {return x;}
    public int getY() {return y;}

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

    public Node(byte x, byte y) {
        this.edges = new LinkedHashSet<>();
        this.x = x;
        this.y = y;
    }

    public Node(byte x, byte y, Entity entity) {
        this.edges = new LinkedHashSet<>();
        this.x = x;
        this.y = y;
        this.entity = entity;
    }

    @Override
    public String toString() {
        return this.getEntity().getEmoji();
    }
}
