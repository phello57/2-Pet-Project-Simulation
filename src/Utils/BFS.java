package Utils;
import DefaultClasses.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import GameClasses.*;

public class BFS {

    // поиск в ширину
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