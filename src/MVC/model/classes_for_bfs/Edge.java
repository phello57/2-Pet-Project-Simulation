package MVC.model.classes_for_bfs;

public class Edge {
    private final Node pointerNode;
    public Edge(Node pointerNode) {
        this.pointerNode = pointerNode;
    }
    public Node getPointerNode() {
        return pointerNode;
    }
}
