package MVC.Controller;

import MVC.Model.GameClasses.Creature;
import MVC.Model.GameClasses.Entity;
import MVC.Model.Model;
import MVC.Model.UtilsClasses.PathNode;
import MVC.Model.UtilsClasses.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Actions {
    public static void makeMove() {
        HashMap<Entity, PathNode> list_goals = Model.getMapListGoals();

        for (Map.Entry<Entity, PathNode> obj : list_goals.entrySet()) {
            PathNode pathNode = obj.getValue();
            Entity entity = obj.getKey();

            if (pathNode.getPathNode().getNode().getEntity() != entity) {
                doSteps(entity);
            } else { // Когда жертва в 1 узле от итерируемой сущности
                doAttack(entity);
            }
        }
    }
    private static void doSteps(Entity pEntity) {
        PathNode goalNode = Model.getMapListGoals().get(pEntity);

        int iCountSteps = ((Creature) (pEntity)).getSteps();

        LinkedList<PathNode> path = new LinkedList<>();
        PathNode curNode = goalNode;
        // разматываем в список
        try {
            while (curNode.getPathNode().getNode() != null) {
                path.addFirst(curNode);
                curNode = curNode.getPathNode();
            }
        } catch (NullPointerException e) {}


        while (iCountSteps != 0 ) {
            PathNode endNode = path.get(0);

            if (endNode.getNode().getEntity() != null) { // если в первом узле кто то есть, то удаляем путь, надо искать вновь
                Model.addToMapRemoveGoals(pEntity, null);
            } else {
                Model.removeFromMapAllEntities(pEntity);
                Model.addToMapAllEntities(pEntity, endNode.getNode() );

                endNode.getPathNode().getNode().setEntity(null);
                endNode.setPathNode(null);
                endNode.getNode().setEntity(pEntity);

                path.removeFirst();
            }

            iCountSteps -= 1;


//        while (iCountSteps != 0 ) {
//            PathNode endNode = goalNode;
//
//            // нужно в endNode дойти до начального узла, что бы свичнуть сущность с первого узла на второй
//            try {
//                while (endNode.getPathNode().getPathNode().getNode() != null) {
//                    endNode = endNode.getPathNode();
//                    //System.out.println(goalNode.getNode().getW()+"_"+goalNode.getNode().getL());
//                }
//            } catch (NullPointerException e) {}
//
//            if (endNode.getNode().getEntity() != null) { // если в первом узле кто то есть, то удаляем путь, надо искать вновь
//                Model.addToMapRemoveGoals(pEntity,null );
//
//            } else {
//                // в глобальной мапе переписываем координаты
//                Model.removeFromMapAllEntities(pEntity);
//                Model.addToMapAllEntities(pEntity, endNode.getNode() );
//
//                // обнуляем во втором узле ссылку
//                // даем второму узлу текущую сущность - перемещаем её по родителям
//                endNode.getPathNode().getNode().setEntity(null);
//                endNode.setPathNode(null);
//                endNode.getNode().setEntity(pEntity);
//            }
//            iCountSteps -= 1;
        }
    }
    private static void doAttack(Entity pEntity) {
        PathNode goalNode = Model.getMapListGoals().get(pEntity);

        int iCountSteps = ((Creature) pEntity ).getSteps();
        int iAttackPoints = ((Creature) pEntity ).getAttackPoints();

        while (iCountSteps != 0 ) {
            Entity victim =  goalNode.getNode().getEntity();

            victim.setHp(victim.getHp() - iAttackPoints);
            iCountSteps -= 1;
        }
    }
}
