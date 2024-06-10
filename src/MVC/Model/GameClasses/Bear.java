package MVC.Model.GameClasses;

import MVC.Model.Model;

public class Bear extends Predator{
    public Bear() {
        this.setEmoji(Model.getEmojiBear());
        this.setHp(Model.getHpBear());
        this.setAttackPoints(Model.getAttackBear());
        this.setSteps(Model.getStepsBear());

        // Список существ, которые являются целью уничтожения
        this.getArrGoals().add(Pig.class.toString());
    }

}
