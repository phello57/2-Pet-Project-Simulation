package game.model.BFS;

public class PathNode {
    private Node node;
    private PathNode pathNode;

    public Node getNode() {
        return node;
    }

    public PathNode getPathNode() {
        return pathNode;
    }

    public void setPathNode(PathNode pathNode) {
        this.pathNode = pathNode;
    }

    public PathNode(Node node, PathNode pathNode) {
        this.node = node;
        this.pathNode = pathNode;
    }


}
