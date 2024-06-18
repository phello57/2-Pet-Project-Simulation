package MVC.model.game_entities;

import MVC.model.classes_for_bfs.Edge;
import MVC.model.classes_for_bfs.Node;
import MVC.model.classes_for_bfs.PathNode;
import MVC.Settings;

import java.util.HashSet;
import java.util.LinkedList;

abstract public class Creature extends Entity{
     Creature(Node node) {
          super(node);
     }
     private int stepsPerRound;
     private int stamina;
     private int hp;
     private final HashSet<String> arrGoals = new HashSet<>();
     public HashSet<String> getArrGoals() {return arrGoals;}

     public void addToArrGoals(String str) {
          arrGoals.add(str);
     }
     public int getHp() {
          return hp;
     }
     public void setHp(int hp) {this.hp = hp;}

     public int getStamina() {
          return stamina;
     }

     public void setStamina(int stamina) {
          this.stamina = stamina;
     }

     private int attackPoints;
     private PathNode currentGoal;
     public PathNode getCurrentGoal() {return currentGoal;}
     public void setCurrentGoal(PathNode currentGoal) {this.currentGoal = currentGoal;}
     public int getAttackPoints() {return attackPoints;}
     public void setAttackPoints(int attack_points) {this.attackPoints = attack_points;}
     public int getSteps() {return stepsPerRound;}
     public void setSteps(int stepsPerRound) {this.stepsPerRound = stepsPerRound;}


     private void initGoal() {
          if (this.getArrGoals().isEmpty()) return;

          if (currentGoal == null
                  || currentGoal.getNode().getEntity() == null
                  || !this.getArrGoals().contains(currentGoal.getNode().getEntity().toString())
          ) {
               this.setCurrentGoal(findShortestPath(this.getCurNode(), this));
          }

     }
     private PathNode findShortestPath(Node pStartNode, Entity pEntity) {

          HashSet<String> setGoals = ((Creature) pEntity).getArrGoals();
          if (setGoals.isEmpty()) {return null;}

          HashSet<Node> setPassed = new HashSet<>();
          LinkedList<PathNode> queue = new LinkedList<>();
          queue.addLast(new PathNode(pStartNode, null));

          setPassed.add(pStartNode);
          while (!queue.isEmpty()) {
               PathNode pathNode = queue.removeFirst();
               if (setGoals.contains(pathNode.getNode().getEntity())) {
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
          PathNode goalNode = this.getCurrentGoal();

          int iCountSteps = this.getSteps();
          int iAttackPoints = this.getAttackPoints();

          while (iCountSteps != 0 ) {
               Creature victim =  (Creature) goalNode.getNode().getEntity();

               victim.setHp(victim.getHp() - iAttackPoints);

               if (victim.getHp() >= 0 ) {
                    if (victim.getClass().getSimpleName().toString().equals("Pig")) {
                         this.setStamina(this.getStamina() + Settings.STAMINA_FROM_PIG);
                    } else if (victim.getClass().getSimpleName().toString().equals("Grass")) {
                         this.setStamina(this.getStamina() + Settings.STAMINA_FROM_GRASS);
                    }

               }
               iCountSteps -= 1;
          }
     }

     public void makeMove() {

          this.initGoal();

          this.setStamina(this.getStamina() - Settings.STAMINA_SUB_PER_ROUND);

          if (this.getStamina() <= 0) {
               this.setHp(this.getHp() - Settings.STAMINA_SUB_HP_PER_ROUND);

          }

          if (currentGoal == null) {

          } else if (currentGoal.getPathNode().getNode().getEntity() == this) { // Когда жертва в 1 узле от итерируемой сущности
               this.attack();
          } else {
               this.doSteps();
          }

     }

     private void doSteps() {
          PathNode goalNode = this.currentGoal;

          int iCountSteps = this.getSteps();

          while (iCountSteps != 0 ) {

               PathNode endNode = goalNode;

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
