package Utils;
import DefaultClasses.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import GameClasses.*;

public class BFS {

    // поиск в ширину
    public static void searchGoal(Node p_node, Entity p_entity) {
        //System.out.println("Current Node: "+ p_node.getValue());

        HashSet<String> victims = p_entity.getArr_goals();


        HashSet<Node> set_passed = new HashSet<>();
        LinkedList<Node> queue = new LinkedList<>();
        set_passed.add(p_node);
        queue.addLast(p_node);

        while(!queue.isEmpty()) {
            Node node = queue.removeFirst();
            try {
                if (victims.contains(node.getEntity().getClass())) {
                    System.out.println("BFS searchGoal");
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


    public static PathNode findShortestPath(Node p_start_node, Entity p_entity) {

        HashSet<String> set_goals = p_entity.getArr_goals();
        if (set_goals.isEmpty()) {return null;}

        HashSet<Node> set_passed = new HashSet<>();
        LinkedList<PathNode> queue = new LinkedList<>();
        queue.addLast(new PathNode(p_start_node, null));

        set_passed.add(p_start_node);
        while (!queue.isEmpty()) {
            PathNode pathNode = queue.removeFirst();
            if (set_goals.contains(pathNode.getNode().getEntity())) return pathNode;

            for (Edge edge : pathNode.getNode().getEdges()) {
                Node pointer_node = edge.getPointerNode();
                if (set_passed.contains(pointer_node)) continue;



                try {
                // Переделать , обход камня
                    if ("class GameClasses.Rock".equals(pointer_node.getEntity().getClass().toString())) {
                        continue;
                    }
                    if (set_goals.contains(pointer_node.getEntity().getClass().toString())) {
                        return new PathNode(pointer_node, pathNode);
                    }
                } catch (NullPointerException e) {}

                queue.addLast(new PathNode(pointer_node, pathNode));
                set_passed.add(pointer_node);
            }
        }
        return null;
    }


    public static PathNode findShortestPath(Node p_start_node, Node p_end_node) {
        HashSet<Node> set_passed = new HashSet<>();
        LinkedList<PathNode> queue = new LinkedList<>();
        queue.addLast(new PathNode(p_start_node, null));

        set_passed.add(p_start_node);

        while (!queue.isEmpty()) {
            PathNode pathNode = queue.removeFirst();
            if (pathNode.getNode() == p_end_node) return pathNode;

            for (Edge edge : pathNode.getNode().getEdges()) {
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