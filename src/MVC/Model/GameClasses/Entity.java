package MVC.Model.GameClasses;

import MVC.Model.UtilsClasses.Node;

import java.util.HashSet;

public abstract class Entity {
    public Node getCurNode() {return curNode;}
    Entity(Node node) {this.curNode = node;}
    public void setCurNode(Node curNode) {
        this.curNode = curNode;
    }
    private Node curNode;
    private String emoji;
    private int hp;
    private final HashSet<String> arrGoals = new HashSet<>();
    public HashSet<String> getArrGoals() {return arrGoals;}

    public void addToArrGoals(String str) {
        arrGoals.add(str);
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {this.hp = hp;}
    public String getEmoji() {
        return emoji;
    }
    public void setEmoji(String emoji) {this.emoji = emoji;}

   }
