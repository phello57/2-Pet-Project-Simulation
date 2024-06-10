package MVC;

import MVC.Controller.*;
import MVC.Model.UtilsClasses.Node;
import MVC.Model.Model;

import java.util.Scanner;

public class Simulation {
    public static void start() {

        initActions();

        while (true) {
            for (Node[] arr : Model.getMapDoubleArrMatrix()) {
                System.out.println();
                for (Node node : arr) {
                    System.out.print(node);
                }
            }

            System.out.println();

            Scanner in2 = new Scanner(System.in);
            System.out.println();
            in2.next();

            nextTurn();
        }
    }
    public static void initActions() {
        View.createMap();
        View.createEntities();
    }

    public static void nextTurn() {
        Controller.findMove();
        Actions.makeMove();
        Controller.removeDeadEntities();
    }
}
