package Utils;

import DefaultClasses.Node;
import GameClasses.Grass;
import GameClasses.Rock;
import GameClasses.Tree;

import java.util.Scanner;

public class Simulation {
    public static void start() {


        Utils.Actions.initActions();

        run_one_cycle();

        while (true) {
            run_one_cycle();
        }
    }

    private static void run_one_cycle() {
        Utils.Actions.nextTurn();

        for (Node[] arr : Settings.getMap_double_arr_matrix()) {
            System.out.println();
            for (Node node : arr) {
                System.out.print(node);
            }
        }
        System.out.println();

        Scanner in2 = new Scanner(System.in);
        System.out.println();
        String name = in2.next();
    }
}
