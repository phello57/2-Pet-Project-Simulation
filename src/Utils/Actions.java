package Utils;

import DefaultClasses.Node;
import DefaultClasses.PathNode;
import GameClasses.Creature;
import GameClasses.Entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static Utils.BFS.*;

public class Actions {
    public static void initActions() {
        Utils.Map.create_map();
        Utils.Map.create_entities();
    }

    /* У всех живых существ вызываем поиск пути */
    public static void nextTurn() {
        findMove();
        makeMove();
        checkHpUnits();
    }
    private static void findMove() {
        HashMap<Entity, Node> list_entities = Settings.getMap_all_entities();
        HashMap<Entity, PathNode> list_goals = Settings.getMap_list_goals();

        for (Map.Entry<Entity, Node> obj : list_entities.entrySet()) {
            Entity entity = obj.getKey();
            Node node = obj.getValue();
            boolean check_that_goal_not_change = false;


            if (!list_goals.containsKey(entity)) {
                createGoal(node, entity, list_goals);
            } else if (list_goals.containsKey(entity)) { // Смотрим в конечную ячейку, на сущность, всё еще ли там находится цель
                Node node2 = list_goals.get(entity).getNode();

                HashSet<String> goals_of_entity = entity.getArr_goals();

                for (String str : goals_of_entity) {
                    try {
                        String entity_class = node2.getEntity().getClass().toString();
                        if (str.equals(entity_class)) {
                            check_that_goal_not_change = true;
                        }
                    } catch (NullPointerException e) {
                        check_that_goal_not_change = false;
                    }
                }
                if (!check_that_goal_not_change) {
                    list_goals.remove(entity);
                    createGoal(node, entity, list_goals);
                }
            }
        }
    }
    public static void createGoal(Node p_node, Entity p_entity,  HashMap<Entity, PathNode> p_list_goals) {
        PathNode pathNode2 = findShortestPath(p_node, p_entity);
        if (pathNode2 == null) {
            return;
        }
        p_list_goals.put(p_entity, pathNode2);
    }

    private static void makeMove() {
        HashMap<Entity, PathNode> list_goals = Settings.getMap_list_goals();


        for (Map.Entry<Entity, PathNode> obj : list_goals.entrySet()) {
            PathNode pathNode = obj.getValue();
            Entity entity = obj.getKey();


            if (pathNode.getPathNode().getNode().getEntity() != entity) {
                Utils.Map.do_steps(entity);
            } else { // Когда жертва в 1 узле от итерируемой сущности
                Utils.Map.do_attack(entity);
            }
        }
    }
    private static void checkHpUnits() {
        HashMap<Entity, Node> list_entities = Settings.getMap_all_entities();

        for (Map.Entry<Entity, Node> obj : list_entities.entrySet()) {
            Node node = obj.getValue();
            Entity entity = obj.getKey();

            if ( ((Creature) entity).getHp() == 0 ) {
                deleteEntityFromEveryWhere(entity, node);
            }
        }
    }
    private static void deleteEntityFromEveryWhere(Entity p_entity, Node node) {
        HashMap<Entity, Node> list_entities = Settings.getMap_all_entities();
        HashMap<Entity, PathNode> list_goals = Settings.getMap_list_goals();

        list_goals.remove(p_entity);
        list_entities.remove(p_entity);
        node.setEntity(null);
    }
}