package MVC.Model.GameClasses;
import MVC.Model.Model;

public class Pig extends Herbivore{
    public Pig() {
        this.setEmoji(Model.getEmojiPig());
        this.setSteps(Model.getStepsPig());
        this.setHp(Model.getHpPig());
        this.setAttackPoints(Model.getAttackPig());

        // Список существ, которые являются целью уничтожения
        this.getArrGoals().add(Grass.class.toString());
    }
}
