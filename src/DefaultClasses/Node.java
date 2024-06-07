package DefaultClasses;

import GameClasses.Entity;
import Utils.Settings;

import java.util.LinkedHashSet;

public class Node {
    private byte w;
    private byte l;

    public int getW() {return w;}
    public int getL() {return l;}

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

    public Node(byte w, byte l) {
        this.edges = new LinkedHashSet<>();
        this.w = w;
        this.l = l;
    }

    public Node(byte w, byte l, Entity entity) {
        this.edges = new LinkedHashSet<>();
        this.w = w;
        this.l = l;
        this.entity = entity;
    }

    @Override
    public String toString() {
        if (this.getEntity() == null) {
            return Settings.getEmoji_void();
        }
        return this.getEntity().getEmoji();
    }
}
