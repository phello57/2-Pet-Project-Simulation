package MVC.Model.GameClasses;

import MVC.Model.UtilsClasses.Edge;
import MVC.Model.UtilsClasses.Node;
import MVC.Model.UtilsClasses.PathNode;
import MVC.Settings;

import java.util.HashSet;
import java.util.LinkedList;

abstract public class Creature extends Entity{
     Creature(Node node) {
          super(node);
     }
     private int stepsPerRound;
     private int stamina;

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

          HashSet<String> set_goals = pEntity.getArrGoals();
          if (set_goals.isEmpty()) {return null;}

          HashSet<Node> set_passed = new HashSet<>();
          LinkedList<PathNode> queue = new LinkedList<>();
          queue.addLast(new PathNode(pStartNode, null));

          set_passed.add(pStartNode);
          while (!queue.isEmpty()) {
               PathNode pathNode = queue.removeFirst();
               if (set_goals.contains(pathNode.getNode().getEntity())) {
                    return pathNode;
               }

               for (Edge edge : pathNode.getNode().getEdges()) {
                    Node pointer_node = edge.getPointerNode();
                    if (set_passed.contains(pointer_node)) continue;

                    try {
                         if (set_goals.contains(pointer_node.getEntity().getClass().toString())) {
                              PathNode pathNode2 = new PathNode(pointer_node, pathNode);
                              return pathNode2;
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

     private void attack() {
          PathNode goalNode = this.getCurrentGoal();

          int iCountSteps = this.getSteps();
          int iAttackPoints = this.getAttackPoints();

          while (iCountSteps != 0 ) {
               Entity victim =  goalNode.getNode().getEntity();

               victim.setHp(victim.getHp() - iAttackPoints);

               if (victim.getHp() <= 0 ) {
                    if (victim.getClass().toString().equals("class MVC.Model.GameClasses.Pig")) {
                         this.setStamina(this.getStamina() + Settings.STAMINA_FROM_PIG);
                    } else if (victim.getClass().toString().equals("class MVC.Model.GameClasses.Grass")) {
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
               System.out.println();
               System.out.println(this.getClass());
               System.out.println("Entity stamina: "+this.getHp());
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
