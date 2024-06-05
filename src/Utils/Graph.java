package Utils;

import DefaultClasses.*;

import java.util.HashMap;

/*
    Создание графа по int[][]
 */
public class Graph {
    static Node add_or_get_node(int value, HashMap<Integer, Node> p_hash) {
        if (value == -1) return null;
        if (p_hash.containsKey(value)) {
            return p_hash.get(value);
        }

        System.out.println("add node:  "+value);

        Node node = new Node(value);
        p_hash.put(value, node);
        return node;
    }

    public static HashMap<Integer, Node> create(int[][] p_file) {

        HashMap<Integer, Node> ret_main_hash = new HashMap<Integer, Node>();

        for (int[] arr : p_file) {
            int i_node_value = arr[0];
            int i_node_pointer = arr[1];

            Node node = add_or_get_node(i_node_value, ret_main_hash);
            Node pointer_node = add_or_get_node(i_node_pointer, ret_main_hash);

            if (pointer_node == null) continue;
            Edge edge = new Edge(pointer_node);

            node.getEdges().add(edge);
            //pointer_node.parents.put(node, edge);

            //System.out.println("From: "+node.getValue()+" to "+pointer_node.getValue());
        }
        return ret_main_hash;
    }

}
