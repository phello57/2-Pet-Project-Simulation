package Utils;
import DefaultClasses.*;
import GameClasses.Entity;

import java.util.HashMap;

public class Settings {

    /*   Map   */
    private static byte map_length = 15;
    private static byte map_width = 15;

    // Наш двухмерный массив с нодами
    private static Node[][] map_double_arr_matrix = new Node[map_width][map_length];
    private static HashMap<String, Node> map_nodes_hashmap = new HashMap<>();

    // <Существо, конечная цель> , храним все цели наших существ, что бы находить их и симулировать их перемещение
    private static HashMap<Entity, PathNode> map_list_goals = new HashMap<>();

    public static HashMap<Entity, Node> getMap_all_entities() {return map_all_entities;}

    private static HashMap<Entity, Node> map_all_entities = new HashMap<>();

    public static HashMap<Entity, Node> getMap_remove_goals() {
        return map_remove_goals;
    }

    private static HashMap<Entity, Node> map_remove_goals = new HashMap<>();


    /*   Spawn   */
    private static int spawn_bear = 1;
    private static int spawn_grass = 14;
    private static int spawn_pig = 4;
    private static int spawn_rock = 17;
    private static int spawn_tree = 10;



    /*   Emojies   */
    private static final String emoji_tree = "\uD83C\uDF34";
    private static final String emoji_rock = "\uD83C\uDFD4\uFE0F";
    private static final String emoji_grass = "\uD83C\uDF3F";
    private static final String emoji_bear = "\uD83D\uDC3B";
    private static final String emoji_pig = "\uD83D\uDC37";
    private static final String emoji_void = ". ";


    /*   Speed   */
    // Значение указано в количествах прохождения узлов за 1 ход
    private static int steps_pig = 1;
    private static int steps_bear = 1;


    /*   Hp   */
    private static final int hp_pig = 30;
    private static final int hp_bear = 30;


    private static  int hp_grass = 5;


    /*   Attack   */
    private static final int attack_bear = 15;
    private static final int attack_pig = 5;


    public static int getHp_grass() {return hp_grass;}
    public static int getAttack_pig() {return attack_pig;}
    public static int getSpawn_bear() {return spawn_bear;}
    public static int getSpawn_grass() {return spawn_grass;}
    public static int getSpawn_pig() {return spawn_pig;}
    public static int getSpawn_rock() {return spawn_rock;}
    public static int getSpawn_tree() {return spawn_tree;}
    public static HashMap<Entity, PathNode> getMap_list_goals() {return map_list_goals;}
    public static HashMap<String, Node> getMap_nodes_hashmap() {return map_nodes_hashmap;}
    public static Node[][] getMap_double_arr_matrix() {return map_double_arr_matrix;}
    public static int getHp_pig() {return hp_pig;}
    public static int getHp_bear() {return hp_bear;}
    public static int getAttack_bear() {return attack_bear;}
    public static String getEmoji_pig() {return emoji_pig;}
    public static String getEmoji_tree() { return emoji_tree; }
    public static String getEmoji_rock() { return emoji_rock; }
    public static String getEmoji_grass() {return emoji_grass;}
    public static String getEmoji_bear() {return emoji_bear;}
    public static String getEmoji_void() {return emoji_void;}
    public static byte getMap_length() {return map_length;}
    public static byte getMap_width() {return map_width;}
    public static int getSteps_pig() {return steps_pig;}
    public static int getSteps_bear() {return steps_bear;}
}
