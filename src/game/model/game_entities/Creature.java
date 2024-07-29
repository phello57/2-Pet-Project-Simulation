package game.model.game_entities;

import game.model.BFS.Edge;
import game.model.BFS.Node;
import game.model.BFS.PathNode;
import game.launch.Settings;

import java.util.HashSet;
import java.util.LinkedList;

abstract public class Creature extends Entity{
     Creature(Node node) {
          super(node);
     }

     protected int stepsPerRound;
     protected int stamina;
     protected int hp;
     protected int attackPoints;


     protected HashSet<String> arrGoals = new HashSet<>();
     protected PathNode currentGoal; // цепочка оберток начиная с цели, которая приводит к this

     public HashSet<String> getArrGoals() {return arrGoals;}

     public int getHp() {return hp;}

     private void detectGoal() {
          if (this.arrGoals.isEmpty()) return;

          if (       currentGoal == null
                  || currentGoal.getNode().getEntity() == null // существо переместилось, а клетка пуста, надо опять искать
                  || !this.arrGoals.contains(currentGoal.getNode().getEntity().toString() ) // если на месте цели какое-то другое существо
          ) {
               this.currentGoal = findPath(this.curNode, this);
          }
     }


     private PathNode findPath(Node pStartNode, Entity pEntity) {

          HashSet<String> setGoals = ((Creature) pEntity).arrGoals;
          if (setGoals.isEmpty()) {return null;}

          HashSet<Node> setPassed = new HashSet<>();
          LinkedList<PathNode> queue = new LinkedList<>();
          queue.addLast(new PathNode(pStartNode, null));


          setPassed.add(pStartNode);
          while (!queue.isEmpty()) {
               PathNode pathNode = queue.removeFirst();
               if (setGoals.contains(pathNode.getNode().getEntity() )) {
                    return pathNode;
               }

               for (Edge edge : pathNode.getNode().getEdges()) {
                    Node pointerNode = edge.getPointerNode();
                    if (setPassed.contains(pointerNode)) continue;

                    try {
                         if (setGoals.contains(pointerNode.getEntity().getClass().toString())) {
                              PathNode pathNode2 = new PathNode(pointerNode, pathNode);
                              return pathNode2;
                         }

                         // Обход любых сущностей
                         if (pointerNode.getEntity() != null) {
                              continue;
                         }
                    } catch (NullPointerException e) {}

                    queue.addLast(new PathNode(pointerNode, pathNode));
                    setPassed.add(pointerNode);
               }
          }
          return null;
     }

     private void attack() {

          int iCountSteps = this.stepsPerRound;

          while (iCountSteps != 0 ) {
               Creature victim =  (Creature) this.currentGoal.getNode().getEntity();

               victim.hp = victim.hp - this.attackPoints;

               if (victim.hp >= 0 ) {
                    if (victim.getClass().getSimpleName().toString().equals("Pig")) {
                         this.stamina = this.stamina + Settings.STAMINA_FROM_PIG;
                    } else if (victim.getClass().getSimpleName().toString().equals("Grass")) {
                         this.stamina = this.stamina + Settings.STAMINA_FROM_GRASS;
                    }

               }
               iCountSteps -= 1;
          }
     }

     public void makeMove() {

          this.detectGoal();

          this.stamina = this.stamina - Settings.STAMINA_SUB_PER_ROUND;

          if (this.stamina <= 0) {
               this.hp = this.hp - Settings.STAMINA_SUB_HP_PER_ROUND;

          }

          if (currentGoal == null) {

          } else if (currentGoal.getPathNode().getNode().getEntity() == this) { // Когда жертва в 1 узле от итерируемой сущности
               this.attack();
          } else {
               this.doSteps();
          }

     }

     private void doSteps() {

          int iCountSteps = this.stepsPerRound;

          while (iCountSteps != 0 ) {

               PathNode endNode = this.currentGoal;

               // нужно в endNode дойти до начального узла, что бы свичнуть сущность с первого узла на второй
               try {
                    while (endNode.getPathNode().getPathNode().getNode() != null) {
                         endNode = endNode.getPathNode();
                    }
               } catch (NullPointerException e) {}

               endNode.getPathNode().getNode().setEntity(null);
               endNode.setPathNode(null);
               endNode.getNode().setEntity(this);
               this.setCurNode(endNode.getNode());

               iCountSteps -= 1;
          }
     }
}
