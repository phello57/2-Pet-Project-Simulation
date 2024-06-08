package Utils;
import DefaultClasses.*;
import GameClasses.*;

import java.util.HashMap;

public class Map {
    public static void create_map() {
        int s_width = Settings.getMap_width();
        int s_length = Settings.getMap_length();

        Node[][] s_matrix = Settings.getMap_double_arr_matrix();
        HashMap<String, Node> s_hashmap = Settings.getMap_nodes_hashmap();


        for (byte wid = 0; wid < s_width; wid++) {  // count []
            for (byte len = 0; len < s_length; len++) { // index
                s_matrix[wid][len] = new Node(wid, len, null);
                s_hashmap.put(wid+"_"+len, s_matrix[wid][len]);
            }
        }
        wrapper_create_edges();
    }

    // Свяжем каждую клетку с 8 клетками вокруг
    private static void wrapper_create_edges() {
        Node[][] s_matrix = Settings.getMap_double_arr_matrix();
        byte s_width = Settings.getMap_width();
        byte s_length = Settings.getMap_length();

        for (byte wid = 0; wid < s_width; wid++) {  // count []
            for (byte len = 0; len < s_length; len++) { // index
                //System.out.println(wid+"___"+len);
                create_edges(wid, len, s_matrix[wid][len], s_matrix);
            }
        }
    }

    private static void create(int p_w, int p_l, Node[][] p_matrix, Node parent_node) {
        // Проверим не вышли ли за пределы массива
        if ( (p_l >= 0 && p_matrix[0].length > p_l)
             && (p_w >= 0 && p_matrix.length > p_w)
        ) {
            parent_node.getEdges().add(new Edge(p_matrix[p_w][p_l]));
            //System.out.println("from: "+parent_node.getW()+"_"+parent_node.getL()+" to "+p_w+"_"+p_l);
        }
    }


    private static void create_edges(int p_w, int p_l, Node p_node, Node[][] p_matrix) {

        create(p_w - 1, p_l - 1 , p_matrix, p_node); // верх лево
        create(p_w - 1, p_l         , p_matrix, p_node);   // центр верх
        create(p_w - 1, p_l + 1 , p_matrix, p_node); // верх право
        create(p_w, p_l - 1          , p_matrix, p_node);     // центр лево
        create(p_w, p_l + 1, p_matrix, p_node); // центр право
        create(p_w + 1, p_l - 1, p_matrix, p_node); // лево низ
        create(p_w + 1, p_l, p_matrix, p_node); // центр низ
        create(p_w + 1, p_l+ 1, p_matrix, p_node); // право низ

    }

    public static void do_steps(Entity p_creature) {
        PathNode goalNode = Settings.getMap_list_goals().get(p_creature);
        int i_count_steps = ((Creature) (p_creature)).getSteps();

        while (i_count_steps != 0 ) {
            PathNode endNode = goalNode;
            try {
                while (endNode.getPathNode().getPathNode().getNode() != null) {
                    endNode = endNode.getPathNode();
                    //System.out.println(goalNode.getNode().getW()+"_"+goalNode.getNode().getL());
                }
            } catch (NullPointerException e) {
                endNode.getPathNode().getNode().setEntity(null);
                endNode.getNode().setEntity(p_creature);
            }


            endNode.setPathNode(null);
            endNode.getNode().setEntity(p_creature);
            i_count_steps -= 1;
        }
    }
    public static void create_entities() {

        Predator bear = new Bear();
        Settings.getMap_double_arr_matrix()[0][0].setEntity(bear);
        Settings.getMap_all_entities().put(bear, Settings.getMap_double_arr_matrix()[0][0]);

        Pig sheep = new Pig();
        Settings.getMap_double_arr_matrix()[5][0].setEntity(sheep);
        Settings.getMap_all_entities().put(sheep, Settings.getMap_double_arr_matrix()[5][0]);

        Rock rock0 = new Rock();
        Settings.getMap_double_arr_matrix()[3][0].setEntity(rock0);
        Settings.getMap_all_entities().put(rock0, Settings.getMap_double_arr_matrix()[3][0]);

        Rock rock1 = new Rock();
        Settings.getMap_double_arr_matrix()[3][1].setEntity(rock1);
        Settings.getMap_all_entities().put(rock1, Settings.getMap_double_arr_matrix()[3][1]);

        Rock rock2 = new Rock();
        Settings.getMap_double_arr_matrix()[3][2].setEntity(rock2);
        Settings.getMap_all_entities().put(rock2, Settings.getMap_double_arr_matrix()[3][2]);
    }
}
