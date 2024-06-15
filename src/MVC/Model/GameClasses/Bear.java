package MVC.Model.GameClasses;

import MVC.Model.UtilsClasses.Node;
import MVC.Settings;

public class Bear extends Creature {
    public Bear(Node node) {
        super(node);
        this.setEmoji(Settings.EMOJI_BEAR);
        this.setSteps(Settings.STEPS_BEAR);
        this.setHp(Settings.HP_BEAR);
        this.setAttackPoints(Settings.ATTACK_BEAR);
        this.setStamina(100);

        // Список существ, которые являются целью уничтожения
        this.getArrGoals().add(Pig.class.toString());
    }

}
