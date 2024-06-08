
import Utils.*;
import GameClasses.*;
import DefaultClasses.*;
import java.util.*;
public class Main {

    public static void main(String[] args)  {
        Grass grass = new Grass();
        Rock rock = new Rock();
        Tree tree = new Tree();

        Utils.Map.create_map();
        Utils.Map.create_entities();

        while (true) {
            for (Node[] arr : Settings.getMap_double_arr_matrix()) {
                System.out.println();
                for (Node node : arr) {
                    System.out.print(node);
                }
            }
            System.out.println();

            Utils.Actions.nextTurn();

            Scanner in = new Scanner(System.in);
            System.out.println();
            String name = in.next();
        }


    }
}