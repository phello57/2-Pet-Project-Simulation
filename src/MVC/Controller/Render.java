package MVC.Controller;

import MVC.Model.GameClasses.GameMap;
import MVC.Model.UtilsClasses.Node;

public class Render {
    public static void printMap(GameMap pMap) {
        Node[][] map = pMap.getMapGame();
        for (int w = 0; w < map.length; w++) {
            System.out.println();
            for (int l = 0; l < map[0].length; l++) {
                System.out.print(map[w][l]);
            }
        }

    }
}
