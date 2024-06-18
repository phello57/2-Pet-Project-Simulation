package MVC.model.game_entities;
import MVC.model.classes_for_bfs.Node;
import MVC.Settings;import MVC.view.Render;

public class Pig extends Creature {
    public Pig(Node node) {
        super(node);
        this.setEmoji(Render.EMOJI_PIG);
        this.setSteps(Settings.STEPS_PIG);
        this.setHp(Settings.HP_PIG);
        this.setAttackPoints(Settings.ATTACK_PIG);
        this.setStamina(Settings.STAMINA_PIG);

        // Список существ, которые являются целью уничтожения
        this.addToArrGoals(Grass.class.toString());
    }
}
