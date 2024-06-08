package GameClasses;

import java.util.HashSet;

public abstract class Entity {
    private String emoji;
    private int hp;
    private final HashSet<String> arr_goals = new HashSet<>();

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {this.hp = hp;}
    public HashSet<String> getArr_goals() {return arr_goals;}
    public String getEmoji() {
        return emoji;
    }
    public void setEmoji(String emoji) {this.emoji = emoji;}
}
