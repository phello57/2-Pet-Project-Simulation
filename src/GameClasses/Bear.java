package GameClasses;

import Utils.Settings;

public class Bear extends Predator{
    public Bear() {
        this.setEmoji(Settings.getEmoji_bear());
        this.setHp(Settings.getHp_bear());
        this.setAttack_points(Settings.getAttack_bear());
        this.setSteps(Settings.getSteps_bear());

        // Список существ, которые являются целью уничтожения
        this.getArr_goals().add(Pig.class.toString());
    }

}
