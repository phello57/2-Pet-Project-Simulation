package GameClasses;
import Utils.Settings;

public class Pig extends Herbivore{
    public Pig() {
        this.setEmoji(Settings.getEmoji_pig());
        this.setSteps(Settings.getSteps_pig());
        this.setHp(Settings.getHp_pig());

        // Список существ, которые являются целью уничтожения
        this.getArr_goals().add(Grass.class.toString());
    }
}
