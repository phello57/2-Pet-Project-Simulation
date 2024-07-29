package game.model.game_entities;
import game.model.BFS.Node;
import game.launch.Settings;import game.view.Render;

public class Pig extends Creature {

    public Pig(Node node) {
        super(node);
        this.emoji = Render.EMOJI_PIG;
        this.stepsPerRound = Settings.STEPS_PIG;
        this.hp = Settings.HP_PIG;
        this.attackPoints = Settings.ATTACK_PIG;
        this.stamina = Settings.STAMINA_PIG;

        // Список существ, которые являются целью уничтожения
        this.arrGoals.add(Grass.class.toString());
    }
}
