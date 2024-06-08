package Utils;

import DefaultClasses.Node;
import DefaultClasses.PathNode;
import GameClasses.Entity;

import java.util.HashMap;
import java.util.Map;

import static Utils.BFS.*;

public class Actions {
    /* У всех живых существ вызываем поиск пути */
    public static void nextTurn() {
        findMove();
        makeMove();
    }
    public static void findMove() {
        HashMap<Entity, Node> list_entities = Settings.getMap_all_entities();
        HashMap<Entity, PathNode> list_goals = Settings.getMap_list_goals();

        for (Map.Entry<Entity, Node> obj : list_entities.entrySet()) {
            Node node = obj.getValue();
            Entity entity = obj.getKey();

            if (!list_goals.containsKey(entity)) {
                PathNode pathNode = findShortestPath(node, entity);
                if (pathNode == null) continue;
                list_goals.put(entity, pathNode);
            }
        }
    }
    public static void makeMove() {
        HashMap<Entity, PathNode> list_goals = Settings.getMap_list_goals();


        for (Map.Entry<Entity, PathNode> obj : list_goals.entrySet()) {
            PathNode pathNode = obj.getValue();
            Entity entity = obj.getKey();

            Utils.Map.do_steps(entity);
        }
    }
}
