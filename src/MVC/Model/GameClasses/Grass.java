package MVC.Model.GameClasses;
import MVC.Model.Model;

public class Grass extends Entity{

    public Grass() {
        this.setHp(Model.getHpGrass());
        this.setEmoji(Model.getEmojiGrass());
    }
}
