package MVC.Controller;

import MVC.Model.UtilsClasses.Node;
import MVC.Model.UtilsClasses.PathNode;
import MVC.Model.GameClasses.Entity;
import MVC.Model.Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import static MVC.Model.UtilsClasses.BFS.*;

public class Controller {

    public static void findMove() {
        HashMap<Entity, Node> listAllEntities = Model.getMapAllEntities();
        HashMap<Entity, PathNode> listGoals = Model.getMapListGoals();

        // каждая сущность в списке
        for (Map.Entry<Entity, Node> obj : listAllEntities.entrySet()) {
            Entity entity = obj.getKey();
            Node node = obj.getValue();

            if (entity.getClass().toString().equals("class Utils.Model.GameClasses.Grass")) continue;
            // !!! Можно ввести на Entity флаг имеет ли сущность какие либо движения

            boolean check_that_goal_not_change = false;

            if (!listGoals.containsKey(entity)) {
                createGoal(node, entity);
            } else { // Смотрим в конечную ячейку, на сущность, всё еще ли там находится цель
                Node curNode = listGoals.get(entity).getNode(); // кей - медведь(текущий entity) , велью - pathnode, у него берем ноду, в ноде цель убийства

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
                    listGoals.remove(entity);
                    createGoal(node, entity);
                }
            }
        }
    }

    private static void createGoal(Node pNode, Entity pEntity) {
        PathNode pathNode2 = findShortestPath(pNode, pEntity);
        if (pathNode2 == null) {
            return;
        }
        // Добавляем в список целей сущность и цель
        Model.putMapListGoals(pEntity, pathNode2);
    }

    private static void checkHpUnits() {
        HashMap<Entity, Node> list_entities = Model.getMapAllEntities();

        for (Iterator<Entity> iterator =
             list_entities.keySet().iterator(); iterator.hasNext(); )
        {
            Entity entity = iterator.next();
            Node node = list_entities.get(entity);

            if ( (entity).getHp() <= 0 ) {
                Model.removeFromMapListGoals(entity);
                iterator.remove();
                Model.addToMapDeadList(entity, node);
            }
        }
    }

    public static void removeDeadEntities() {
        checkHpUnits();

        for (Map.Entry<Entity, Node> obj : Model.getMapDeadList().entrySet()){
            Node node = obj.getValue();
            Model.removeFromMapAllEntities(obj.getKey());
            Model.removeFromMapListGoals(obj.getKey());
            node.setEntity(null);
        }

        Model.clearMapDeadList();
        removeUselessGoals();

    }

    private static void removeUselessGoals() {
        HashMap<Entity, Node> removeGoals = Model.getMapRemoveGoals();

        for (Map.Entry<Entity, Node> obj : removeGoals.entrySet()) {
            Entity entity = obj.getKey();
            Model.removeFromMapRemoveGoals(entity, null);

        }
        Model.clearMapRemoveGoals();
    }

    public static void createMapCell(int pWidth, int pLength, Node pNode) {
        Model.setNodeMapGame(pWidth, pLength, pNode);
    }

    public static void createEntityOnGameMap(Entity pEntity, Node pNode){
        pNode.setEntity(pEntity);
        Model.addToMapAllEntities(pEntity, pNode);
    }
}
