package MVC.Model.UtilsClasses;

import java.util.HashSet;
import java.util.LinkedList;

import MVC.Model.GameClasses.Entity;

public class BFS {

    // поиск в ширину
    public static PathNode findShortestPath(Node pStartNode, Entity pEntity) {

        HashSet<String> set_goals = pEntity.getArrGoals();
        if (set_goals.isEmpty()) {return null;}

        HashSet<Node> set_passed = new HashSet<>();
        LinkedList<PathNode> queue = new LinkedList<>();
        queue.addLast(new PathNode(pStartNode, null));

        set_passed.add(pStartNode);
        while (!queue.isEmpty()) {
            PathNode pathNode = queue.removeFirst();
            if (set_goals.contains(pathNode.getNode().getEntity())) return pathNode;

            for (Edge edge : pathNode.getNode().getEdges()) {
                Node pointer_node = edge.getPointerNode();
                if (set_passed.contains(pointer_node)) continue;

                try {
                    if (set_goals.contains(pointer_node.getEntity().getClass().toString())) {
                        return new PathNode(pointer_node, pathNode);
                    }

                    // Обход любых сущностей
                    if (!pointer_node.getEntity().getClass().toString().isEmpty()) {
                        continue;
                    }
                } catch (NullPointerException e) {}

                queue.addLast(new PathNode(pointer_node, pathNode));
                set_passed.add(pointer_node);
            }
        }
        return null;
    }

}