package MVC.model.game_entities;

import MVC.model.classes_for_bfs.Node;

import java.util.HashSet;

public abstract class Entity {
    Entity(Node node) {this.curNode = node;}

    private Node curNode;
    private String emoji;

    public String getEmoji() {return emoji;}
    public Node getCurNode() {return curNode;}
    public void setCurNode(Node curNode) {this.curNode = curNode;}
    public void setEmoji(String emoji) {this.emoji = emoji;}
   }
