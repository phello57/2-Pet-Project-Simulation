package Utils;
import DefaultClasses.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import GameClasses.*;

public class BFS {
    public static void iteration(Node p_node) {
        //System.out.println("Current Node: "+ p_node.getValue());

        HashSet<Node> set_passed = new HashSet<>();
        LinkedList<Node> queue = new LinkedList<>();
        set_passed.add(p_node);
        queue.addLast(p_node);

        while(!queue.isEmpty()) {
            Node node = queue.removeFirst();
            try {
                if (node.getEntity().getClass() == Pig.class) {
                    System.out.println();
                    System.out.println("PIG DETECTED");
                    System.out.println(node.getW()+" "+node.getL());
                }
            } catch (NullPointerException e) {}

            for (Edge edge : node.getEdges()) {
                Node pointer_node = edge.getPointerNode();
                if (!set_passed.contains(pointer_node)) {
                    queue.addLast(pointer_node);
                    set_passed.add(pointer_node);
                }
            }
        }
    }

    public static PathNode findShortestPath(Node p_start_node, Node p_end_node) {
        HashSet<Node> set_passed = new HashSet<>();
        LinkedList<PathNode> queue = new LinkedList<>();
        queue.addLast(new PathNode(p_start_node, null));

        set_passed.add(p_start_node);

        while (!queue.isEmpty()) {
            PathNode pathNode = queue.removeFirst();
            if (pathNode.node == p_end_node) return pathNode;

            for (Edge edge : pathNode.node.getEdges()) {
                Node pointer_node = edge.getPointerNode();
                if (set_passed.contains(pointer_node)) continue;

                if (pointer_node == p_end_node) return new PathNode(pointer_node, pathNode);

                queue.addLast(new PathNode(pointer_node, pathNode));
                set_passed.add(pointer_node);
            }
        }
        return null;
    }
}