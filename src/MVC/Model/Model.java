package MVC.Model;
import MVC.Model.GameClasses.Entity;
import MVC.Model.UtilsClasses.Node;
import MVC.Model.UtilsClasses.PathNode;

import java.util.HashMap;

public class Model {

    /*   Map   */
    private static final int MAP_LENGTH = 15;
    private static final int MAP_WIDTH = 15;
    private static final Node[][] MAP_GAME_MAP = new Node[MAP_WIDTH][MAP_LENGTH];
    private static final HashMap<Entity, Node> MAP_ALL_ENTITIES = new HashMap<>();
    private static final HashMap<Entity, PathNode> MAP_LIST_GOALS = new HashMap<>();
    private static final HashMap<Entity, Node> MAP_REMOVE_GOALS = new HashMap<>();
    private static final HashMap<Entity, Node> MAP_DEAD_LIST_THIS_ROUND = new HashMap<>();

    /*   Spawn   */
    private static final int SPAWN_BEAR = 1;
    private static final int SPAWN_GRASS = 15;
    private static final int SPAWN_PIG = 4;
    private static final int SPAWN_ROCK = 0;
    private static final int SPAWN_TREE = 0;

    /*   Emojies   */
    private static final String EMOJI_TREE = "\uD83C\uDF34";
    private static final String EMOJI_ROCK = "\uD83C\uDFD4\uFE0F️";
    private static final String EMOJI_GRASS = "\uD83C\uDF3F";
    private static final String EMOJI_BEAR = "\uD83D\uDC3B";
    private static final String EMOJI_PIG = "\uD83D\uDC37";
    private static final String EMOJI_VOID = ". ";


    /*   Speed   */ // Кол-во прохождения узлов за 1 рендер
    private static final int STEPS_PIG = 1;
    private static final int STEPS_BEAR = 1;


    /*   Hp   */
    private static final int HP_PIG = 30;
    private static final int HP_BEAR = 30;
    private static final int HP_GRASS = 5;



    /*   Attack   */
    private static final int ATTACK_BEAR = 15;
    private static final int ATTACK_PIG = 5;






    public static HashMap<Entity, Node> getMapDeadList() {
        return MAP_DEAD_LIST_THIS_ROUND;
    }
    public static void addToMapDeadList(Entity pEntity, Node pNode) {
        MAP_DEAD_LIST_THIS_ROUND.put(pEntity, pNode);
    }
    public static HashMap<Entity, Node> getMapAllEntities() {
        return MAP_ALL_ENTITIES;
    }
    public static void addToMapAllEntities(Entity pEntity, Node pNode) {
        MAP_ALL_ENTITIES.put(pEntity, pNode);
    }
    public static void removeFromMapAllEntities(Entity pEntity) {
        MAP_ALL_ENTITIES.remove(pEntity);
    }
    public static HashMap<Entity, Node> getMapRemoveGoals() {
        return MAP_REMOVE_GOALS;
    }
    public static void addToMapRemoveGoals(Entity pEntity, Node pNode) {
        MAP_REMOVE_GOALS.put(pEntity, pNode);
    }
    public static void removeFromMapRemoveGoals(Entity pEntity, Node pNode) {
        MAP_REMOVE_GOALS.remove(pEntity);
    }
    public static int getHpGrass() {return HP_GRASS;}
    public static int getAttackPig() {return ATTACK_PIG;}
    public static int getSpawnBear() {return SPAWN_BEAR;}
    public static int getSpawnGrass() {return SPAWN_GRASS;}
    public static int getSpawnPig() {return SPAWN_PIG;}
    public static int getSpawnRock() {return SPAWN_ROCK;}
    public static int getSpawnTree() {return SPAWN_TREE;}
    public static HashMap<Entity, PathNode> getMapListGoals() {return MAP_LIST_GOALS;}
    public static void clearMapDeadList () {
        MAP_LIST_GOALS.clear();
    }
    public static void removeFromMapListGoals(Entity pEntity) {
        MAP_LIST_GOALS.remove(pEntity);
    }
    public static void clearMapRemoveGoals(){
        MAP_REMOVE_GOALS.clear();
    }
    public static void putMapListGoals(Entity pEntity, PathNode pPathNode) {
        MAP_LIST_GOALS.put(pEntity, pPathNode);
    }
    public static Node[][] getMapDoubleArrMatrix() {return MAP_GAME_MAP;}
    public static Node getNodeOnCoordinate(int width, int length) {
        return MAP_GAME_MAP[width][length];
    }
    public static void setNodeMapGame(int pWidth, int pLength, Node pNode) {MAP_GAME_MAP[pWidth][pLength] = pNode;}
    public static int getHpPig() {return HP_PIG;}
    public static int getHpBear() {return HP_BEAR;}
    public static int getAttackBear() {return ATTACK_BEAR;}
    public static String getEmojiPig() {return EMOJI_PIG;}
    public static String getEmojiTree() { return EMOJI_TREE; }
    public static String getEmojiRock() { return EMOJI_ROCK; }
    public static String getEmojiGrass() {return EMOJI_GRASS;}
    public static String getEmojiBear() {return EMOJI_BEAR;}
    public static String getEmojiVoid() {return EMOJI_VOID;}
    public static byte getMapLength() {return MAP_LENGTH;}
    public static byte getMapWidth() {return MAP_WIDTH;}
    public static int getStepsPig() {return STEPS_PIG;}
    public static int getStepsBear() {return STEPS_BEAR;}
}
