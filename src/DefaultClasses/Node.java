package DefaultClasses;

import GameClasses.Entity;
import Utils.Settings;

import java.util.LinkedHashSet;

public class Node {
    private final int w;
    private final int l;

    private Entity entity;
    private final LinkedHashSet<Edge> edges;

    public LinkedHashSet<Edge> getEdges() {return edges;}

    public Entity getEntity() {return entity;}
    public void setEntity(Entity entity) {this.entity = entity;}

    public Node(int w, int l) {
        this.edges = new LinkedHashSet<>();
        this.w = w;
        this.l = l;
    }
    @Override
    public String toString() {
        if (this.getEntity() == null) {
            return Settings.getEmoji_void();
        }
        return this.getEntity().getEmoji();
    }
}
