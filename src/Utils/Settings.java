package Utils;

public class Settings {

    /*   Emojies   */
    private static final String emoji_tree = "\uD83C\uDF34";
    private static final String emoji_rock = "\uD83D\uDDFF";
    private static final String emoji_grass = "\uD83C\uDF3F";
    private static final String emoji_bear = "\uD83D\uDC3B";
    private static final String emoji_sheep = "\uD83D\uDC11";


    /*   Speed   */
    // Значение указано в количествах прохождения узлов за 1 ход
    private static final int speed_sheep = 1;
    private static final int speed_bear = 2;


    /*   Hp   */
    private static final int hp_sheep = 30;
    private static final int hp_bear = 30;


    /*   Attack   */
    private static final int attack_bear = 15;




    public static int getSpeed_sheep() {return speed_sheep;}
    public static int getSpeed_bear() {return speed_bear;}
    public static int getHp_sheep() {return hp_sheep;}
    public static int getHp_bear() {return hp_bear;}
    public static int getAttack_bear() {return attack_bear;}
    public static String getEmoji_sheep() {return emoji_sheep;}
    public static String getEmoji_tree() { return emoji_tree; }
    public static String getEmoji_rock() { return emoji_rock; }
    public static String getEmoji_grass() {return emoji_grass;}
    public static String getEmoji_bear() {return emoji_bear;}
}
