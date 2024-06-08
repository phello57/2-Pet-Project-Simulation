package Utils;

import DefaultClasses.Node;
import GameClasses.Grass;
import GameClasses.Rock;
import GameClasses.Tree;

import java.util.Scanner;

public class Simulation {
    public static void start() {
        //Grass grass = new Grass();
        //Rock rock = new Rock();
        //Tree tree = new Tree();


        Utils.Actions.initActions();
        while (true) {
            Utils.Actions.nextTurn();

            for (Node[] arr : Settings.getMap_double_arr_matrix()) {
                System.out.println();
                for (Node node : arr) {
                    System.out.print(node);
                }
            }
            System.out.println();

            Scanner in = new Scanner(System.in);
            System.out.println();
            String name = in.next();
        }
    }
}
