package GameClasses;
import Utils.Settings;
import Utils.Settings.*;

public class Grass extends Entity{

    public Grass() {
        this.setHp(Settings.getHp_grass());
        this.setEmoji(Settings.getEmoji_grass());
    }
}
