package GameClasses;

import Utils.Settings;

public class Bear extends Predator{
    public Bear() {
        this.setEmoji(Settings.getEmoji_bear());
        this.setSpeed(Settings.getSpeed_bear());
        this.setHp(Settings.getHp_bear());
        this.setAttack_points(Settings.getAttack_bear());
    }
}
