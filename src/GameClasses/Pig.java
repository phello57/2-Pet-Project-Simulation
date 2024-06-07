package GameClasses;
import Utils.Settings;

public class Pig extends Herbivore{
    public Pig() {
        this.setEmoji(Settings.getEmoji_pig());
        //this.setSpeed(Settings.getSpeed_pig());
        this.setHp(Settings.getHp_pig());
    }
}
