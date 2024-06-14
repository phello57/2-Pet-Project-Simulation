package MVC.Model.GameClasses;
import MVC.Model.UtilsClasses.Node;
import MVC.Settings;

public class Pig extends Creature {
    public Pig(Node node) {
        super(node);
        this.setEmoji(Settings.EMOJI_PIG);
        this.setSteps(Settings.STEPS_PIG);
        this.setHp(Settings.HP_PIG);
        this.setAttackPoints(Settings.ATTACK_PIG);

        // Список существ, которые являются целью уничтожения

        this.getArrGoals().add(Grass.class.toString());
    }
}
