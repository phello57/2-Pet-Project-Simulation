package GameClasses;

import java.util.HashSet;

public abstract class Entity {
    private String emoji;
    private int hp;
    private final HashSet<String> arrGoals = new HashSet<>();

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {this.hp = hp;}
    public HashSet<String> getArrGoals() {return arrGoals;}
    public String getEmoji() {
        return emoji;
    }
    public void setEmoji(String emoji) {this.emoji = emoji;}
}
