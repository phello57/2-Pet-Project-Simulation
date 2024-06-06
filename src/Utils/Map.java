package Utils;
import DefaultClasses.*;
import GameClasses.Rock;

import java.util.HashMap;

public class Map {
    public static void create() {
        int s_width = Settings.getMap_width();
        int s_length = Settings.getMap_length();

        Node[][] s_matrix = Settings.getMap_double_arr_matrix();
        HashMap<String, Node> s_hashmap = Settings.getMap_nodes_hashmap();


        for (byte wid = 0; wid < s_width; wid++) {  // count []
            for (byte len = 0; len < s_length; len++) { // index
                s_matrix[wid][len] = new Node(wid, len, new Rock());
                s_hashmap.put(wid+"_"+len, s_matrix[wid][len]);
            }
        }
        wrapper_create_edges();
    }
    private static void wrapper_create_edges() {
        Node[][] s_matrix = Settings.getMap_double_arr_matrix();
        byte s_width = Settings.getMap_width();
        byte s_length = Settings.getMap_length();

        for (byte wid = 0; wid < s_width; wid++) {  // count []
            for (byte len = 0; len < s_length; len++) { // index
                create_edges(wid, len, s_matrix[wid][len], s_matrix);
            }
        }
    }

    private static void create(byte p_w, byte p_l, Node[][] p_matrix, Node parent_node) {
        if ( (p_l >= 0 && p_matrix[0].length >= p_l)
             && (p_w >= 0 && p_matrix.length >= p_w)
        ) {
            parent_node.getEdges().add(new Edge(p_matrix[p_w][p_l]));
            System.out.println("edge: "+p_l+"_"+p_w);
        }
    }

    private static void create_edges(byte p_w, byte p_l, Node p_node, Node[][] p_matrix) {

        create(p_w--, p_l--, p_matrix, p_node); // верх лево
        create(p_w--, p_l, p_matrix, p_node);   // центр верх
        create(p_w--, p_l++, p_matrix, p_node); // верх право
        create(p_w, p_l--, p_matrix, p_node);     // центр лево
        create(p_w, p_l++, p_matrix, p_node); // центр право
        create(p_w++, p_l--, p_matrix, p_node); // лево низ
        create(p_w++, p_l, p_matrix, p_node); // центр низ
        create(p_w++, p_l++, p_matrix, p_node); // право низ

    }
}
