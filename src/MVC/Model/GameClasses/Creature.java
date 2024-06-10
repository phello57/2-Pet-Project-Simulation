package MVC.Model.GameClasses;


abstract public class Creature extends Entity{
     private int stepsPerRound;
     private int attackPoints;

     public int getAttackPoints() {return attackPoints;}
     public void setAttackPoints(int attack_points) {this.attackPoints = attack_points;}
     public int getSteps() {
          return stepsPerRound;
     }
     public void setSteps(int stepsPerRound) {
          this.stepsPerRound = stepsPerRound;
     }
}
