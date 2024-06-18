package MVC.model.game_entities;

import MVC.model.classes_for_bfs.Node;
import MVC.Settings;
import MVC.view.Render;
public class Bear extends Creature {
    public Bear(Node node) {
        super(node);
        this.setEmoji(Render.EMOJI_BEAR);
        this.setSteps(Settings.STEPS_BEAR);
        this.setHp(Settings.HP_BEAR);
        this.setAttackPoints(Settings.ATTACK_BEAR);
        this.setStamina(Settings.STAMINA_BEAR);

        // Список существ, которые являются целью уничтожения
        this.addToArrGoals(Pig.class.toString());
    }

}
