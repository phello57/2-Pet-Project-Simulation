package GameClasses;
import Utils.Settings;
import Utils.Settings.*;

public class Grass extends Entity{

    public Grass() {
        this.setHp(Settings.getHpGrass());
        this.setEmoji(Settings.getEmojiGrass());
    }
}
