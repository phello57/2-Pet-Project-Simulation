
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

//        Node node0 = new Node(1, grass);
//        Node node1 = new Node(2, rock);
//        Node node2 = new Node(3, tree);
//        Node node3 = new Node(4, grass);
//
//        Node[][] node_file = new Node[][]{
//                {node0, node1}
//                ,{node2, node3}
//        };
//
//        int i = 0;

        Utils.Map.create();
        for (Node[] arr : Settings.getMap_double_arr_matrix()) {
            System.out.println();
            for (Node node : arr) {
                System.out.print(node);
            }
        }
        HashMap<String, Node> hashmap = Settings.getMap_nodes_hashmap();
        for (java.util.Map.Entry<String, Node> entry : hashmap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}