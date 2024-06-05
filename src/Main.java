
import Utils.*;
import GameClasses.*;
import DefaultClasses.*;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Grass grass = new Grass();
        Rock rock = new Rock();
        Tree tree = new Tree();
        Predator bear = new Bear();

        System.out.println(grass.getEmoji());
        System.out.println(rock.getEmoji());
        System.out.println(tree.getEmoji());
        System.out.println(bear.getEmoji());

        int[][] file = new int[][]{
                {1, 2, 0}
                , {2, 3, 0}
                , {2, 4, 0}
                , {4, 9, 0}
                , {4, 10, 0}

                , {1, 5, 0}
                , {5, 6, 0}
                , {6, 7, 0}
                , {6, 8, 0}
                , {7, 8, 0}

        };

        HashMap<Integer, Node> main_hash = Graph.create(file);
    }
}