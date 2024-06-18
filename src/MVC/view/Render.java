package MVC.view;

import MVC.model.game_entities.GameMap;
import MVC.model.classes_for_bfs.Node;

public class Render {
    /*   Emojies   */
    public static final String EMOJI_TREE = "\uD83C\uDF34";
    public static final String EMOJI_ROCK = "\uD83C\uDFD4\uFE0F️";
    public static final String EMOJI_GRASS = "\uD83C\uDF3F";
    public static final String EMOJI_BEAR = "\uD83D\uDC3B";
    public static final String EMOJI_PIG = "\uD83D\uDC37";
    public static final String EMOJI_VOID = ". ";
    public static void printMap(GameMap pMap) {
        Node[][] map = pMap.getdArrGameMap();
        for (int w = 0; w < map.length; w++) {
            System.out.println();
            for (int l = 0; l < map[0].length; l++) {
                System.out.print(map[w][l]);
            }
        }

    }
}
