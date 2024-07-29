package game.view;

import game.model.game_entities.GameMap;
import game.model.BFS.Node;

public class Render {
    /*   Emojies   */
    public static final String EMOJI_TREE = "\uD83C\uDF34";
    public static final String EMOJI_ROCK = "\uD83C\uDFD4\uFE0F️";
    public static final String EMOJI_GRASS = "\uD83C\uDF3F";
    public static final String EMOJI_BEAR = "\uD83D\uDC3B";
    public static final String EMOJI_PIG = "\uD83D\uDC37";
    public static final String EMOJI_VOID = ". ";

    private GameMap world;

    public Render(GameMap world) {
        this.world = world;
    }
    public void printMap() {
        Node[][] map = world.getGAME_MAP();

        for (int w = 0; w < map.length; w++) {
            System.out.println();
            for (int l = 0; l < map[0].length; l++) {
                if (map[w][l].getEntity() != null){
                    System.out.print(map[w][l].getEntity().getEmoji());
                } else {
                    System.out.print(EMOJI_VOID);
                }
            }
        }

    }
}
