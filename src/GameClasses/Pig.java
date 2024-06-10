package GameClasses;
import Utils.Settings;

public class Pig extends Herbivore{
    public Pig() {
        this.setEmoji(Settings.getEmojiPig());
        this.setSteps(Settings.getStepsPig());
        this.setHp(Settings.getHpPig());
        this.setAttackPoints(Settings.getAttackPig());

        // Список существ, которые являются целью уничтожения
        this.getArrGoals().add(Grass.class.toString());
    }
}
