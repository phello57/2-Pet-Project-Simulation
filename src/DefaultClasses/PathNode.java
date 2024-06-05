package DefaultClasses;

public class PathNode {
    public Node node;
    public PathNode pathNode;

    public PathNode(Node node, PathNode pathNode) {
        this.node = node;
        this.pathNode = pathNode;
    }
}
