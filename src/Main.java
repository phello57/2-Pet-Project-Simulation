
import Utils.*;
import GameClasses.*;
import DefaultClasses.*;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grass grass = new Grass();
        Rock rock = new Rock();
        Tree tree = new Tree();
        Predator bear = new Bear();
        Pig sheep = new Pig();


        Utils.Map.create();
        Settings.getMap_double_arr_matrix()[0][3].setEntity(bear);
        Settings.getMap_double_arr_matrix()[0][18].setEntity(sheep);
        for (Node[] arr : Settings.getMap_double_arr_matrix()) {
            System.out.println();
            for (Node node : arr) {
                System.out.print(node);
            }
        }
        BFS.iteration(Settings.getMap_double_arr_matrix()[0][3]);
        PathNode end = BFS.findShortestPath( Settings.getMap_double_arr_matrix()[0][3]
                            , Settings.getMap_double_arr_matrix()[0][18]);
        while (end.pathNode != null) {
            System.out.println(end.node.getW()+"_"+end.node.getL());
            end = end.pathNode;
        }
    }
}