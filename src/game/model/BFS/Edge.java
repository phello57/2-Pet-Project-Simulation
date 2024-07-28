package game.model.BFS;

public class Edge {
    private final Node pointerNode;
    public Edge(Node pointerNode) {
        this.pointerNode = pointerNode;
    }
    public Node getPointerNode() {
        return pointerNode;
    }
}
