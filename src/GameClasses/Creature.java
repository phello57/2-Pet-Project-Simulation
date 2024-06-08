package GameClasses;


abstract public class Creature extends Entity{
     private int steps_per_round;
     private int attack_points;

     public int getAttack_points() {return attack_points;}
     public void setAttack_points(int attack_points) {this.attack_points = attack_points;}
     public int getSteps() {
          return steps_per_round;
     }
     public void setSteps(int steps_per_round) {
          this.steps_per_round = steps_per_round;
     }
}
