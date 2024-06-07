package GameClasses;

import java.util.ArrayList;

public abstract class Entity {
    String emoji;
    ArrayList<Object> arr_goals = new ArrayList<>();
    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
