package GameClasses;


abstract public class Creature extends Entity{
     private int hp;
     private int steps_per_round;

     public int getHp() {
          return hp;
     }

     public void setHp(int hp) {
          this.hp = hp;
     }

     public int getSteps() {
          return steps_per_round;
     }

     public void setSteps(int steps_per_round) {
          this.steps_per_round = steps_per_round;
     }
}
