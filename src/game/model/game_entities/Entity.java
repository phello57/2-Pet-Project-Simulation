package game.model.game_entities;

import game.model.BFS.Node;

public abstract class Entity {
    Entity(Node node) {this.curNode = node;}

    protected Node curNode;
    protected String emoji;

    public String getEmoji() {return emoji;}
    public void setEmoji(String emoji) {this.emoji = emoji;}

    public Node getCurNode() {return curNode;}
    public void setCurNode(Node curNode) {this.curNode = curNode;}

   }
