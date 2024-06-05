package GameClasses;
import Utils.Settings;
import Utils.Settings.*;

public class Sheep extends Herbivore{
    public Sheep() {
        this.setEmoji(Settings.getEmoji_sheep());
        this.setSpeed(Settings.getSpeed_sheep());
        this.setHp(Settings.getHp_sheep());
    }
}
