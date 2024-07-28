package game.model.game_entities;

import game.model.BFS.Node;
import game.Settings;
import game.view.Render;
public class Bear extends Creature {
    public Bear(Node node) {
        super(node);
        this.emoji = Render.EMOJI_BEAR;
        this.stepsPerRound = Settings.STEPS_BEAR;
        this.hp = Settings.HP_BEAR;
        this.attackPoints = Settings.ATTACK_BEAR;
        this.stamina = Settings.STAMINA_BEAR;

        // Список существ, которые являются целью уничтожения
        this.arrGoals.add(Pig.class.toString());



    }

}
