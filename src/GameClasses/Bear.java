package GameClasses;

import Utils.Settings;

public class Bear extends Predator{
    public Bear() {
        this.setEmoji(Settings.getEmojiBear());
        this.setHp(Settings.getHpBear());
        this.setAttackPoints(Settings.getAttackBear());
        this.setSteps(Settings.getStepsBear());

        // Список существ, которые являются целью уничтожения
        this.getArrGoals().add(Pig.class.toString());
    }

}
