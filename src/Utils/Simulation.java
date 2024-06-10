package Utils;

import DefaultClasses.Node;
import GameClasses.Grass;
import GameClasses.Rock;
import GameClasses.Tree;

import java.util.Scanner;

public class Simulation {
    public static void start() {

        Utils.Actions.initActions();

        while (true) {
            for (Node[] arr : Settings.getMapDoubleArrMatrix()) {
                System.out.println();
                for (Node node : arr) {
                    System.out.print(node);
                }
            }

            System.out.println();

            Scanner in2 = new Scanner(System.in);
            System.out.println();
            in2.next();

            Utils.Actions.nextTurn();
        }
    }
}
