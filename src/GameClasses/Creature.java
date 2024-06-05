package GameClasses;

abstract public class Creature extends Entity{
     private int hp;


     private int speed;

     public int getHp() {
          return hp;
     }

     public void setHp(int hp) {
          this.hp = hp;
     }

     public int getSpeed() {
          return speed;
     }

     public void setSpeed(int speed) {
          this.speed = speed;
     }
}
