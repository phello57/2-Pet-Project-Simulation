package Utils;

import DefaultClasses.Node;
import DefaultClasses.PathNode;
import GameClasses.Entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import static Utils.BFS.*;

public class Actions {
    public static void initActions() {
        Utils.Map.createMap();
        Utils.Map.createEntities();
    }
    public static void nextTurn() {
        findMove();
        makeMove();

        checkHpUnits();
        removeDeadEntities();
        removeUselessGoals();
    }
    private static void findMove() {
        HashMap<Entity, Node> list_entities = Settings.getMapAllEntities();
        HashMap<Entity, PathNode> list_goals = Settings.getMapListGoals();

        // каждая сущность в списке
        for (Map.Entry<Entity, Node> obj : list_entities.entrySet()) {
            Entity entity = obj.getKey();
            Node node = obj.getValue();

            if (entity.getClass().toString().equals("class GameClasses.Grass")) continue;
            // !!! Можно ввести на Entity флаг имеет ли сущность какие либо движения

            boolean check_that_goal_not_change = false;


            if (!list_goals.containsKey(entity)) {
                createGoal(node, entity);
            } else if (list_goals.containsKey(entity)) { // Смотрим в конечную ячейку, на сущность, всё еще ли там находится цель
                Node curNode = list_goals.get(entity).getNode() ;// кей - медведь(текущий entity) , велью - pathnode, у него берем ноду, в ноде цель убийства

                HashSet<String> goalsOfEntity = entity.getArrGoals();

                for (String str : goalsOfEntity) {
                    try {
                        String entity_class = curNode.getEntity().getClass().toString();
                        if (str.equals(entity_class)) {
                            check_that_goal_not_change = true;
                        }
                    } catch (NullPointerException e) { // там пусто, свинья движется куда то
                        check_that_goal_not_change = false;
                    }
                }
                if (!check_that_goal_not_change) { // удаляем путь, ищем снова
                    list_goals.remove(entity);
                    createGoal(node, entity);
                }
            }
        }
    }

    public static void createGoal(Node pNode, Entity pEntity) {
        PathNode pathNode2 = findShortestPath(pNode, pEntity);
        if (pathNode2 == null) {
            return;
        }
        // Добавляем в список целей сущность и цель
        Settings.putMapListGoals(pEntity, pathNode2);
    }

    private static void makeMove() {
        HashMap<Entity, PathNode> list_goals = Settings.getMapListGoals();

        for (Map.Entry<Entity, PathNode> obj : list_goals.entrySet()) {
            PathNode pathNode = obj.getValue();
            Entity entity = obj.getKey();

            if (pathNode.getPathNode().getNode().getEntity() != entity) {
                Utils.Map.doSteps(entity);
            } else { // Когда жертва в 1 узле от итерируемой сущности
                Utils.Map.doAttack(entity);
            }
        }
    }

    private static void checkHpUnits() {
        HashMap<Entity, Node> list_entities = Settings.getMapAllEntities();

        for (Iterator<Entity> iterator =
             list_entities.keySet().iterator(); iterator.hasNext(); )
        {
            Entity entity = iterator.next();
            Node node = list_entities.get(entity);

            if ( (entity).getHp() <= 0 ) {
                Settings.removeFromMapListGoals(entity);
                iterator.remove();
                Settings.addToMapDeadList(entity, node);
            }
        }
    }

    public static void removeDeadEntities() {
        for (Map.Entry<Entity, Node> obj : Settings.getMapDeadList().entrySet()){
            Node node = obj.getValue();
            node.setEntity(null);
        }
        Settings.clearMapDeadList();
    }

    private static void removeUselessGoals() {
        HashMap<Entity, Node> remove_goals = Settings.getMapRemoveGoals();

        for (Map.Entry<Entity, Node> obj : remove_goals.entrySet()) {
            Entity entity = obj.getKey();
            Settings.removeFromMapListGoals(entity);
        }
        Settings.clearMapRemoveGoals();
    }
}
