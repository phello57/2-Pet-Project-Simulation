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

    public static void do_steps(Entity p_entity) {
        PathNode goalNode = Settings.getMap_list_goals().get(p_entity);
        int i_count_steps = ((Creature) (p_entity)).getSteps();

        while (i_count_steps != 0 ) {
            PathNode endNode = goalNode;

            // нужно в endNode дойти до начального узла, что бы свичнуть сущность с первого узла на второй
            try {
                while (endNode.getPathNode().getPathNode().getNode() != null) {
                    endNode = endNode.getPathNode();
                    //System.out.println(goalNode.getNode().getW()+"_"+goalNode.getNode().getL());
                }
            } catch (NullPointerException e) { // сработает ошибка,




            }



            // обнуляем во втором узле ссылку
            // даем второму узлу текущую сущность - перемещаем её по родителям
            if (endNode.getNode().getEntity() != null) { // если в первом узле кто то есть, то удаляем путь, надо искать вновь
                Settings.getMap_remove_goals().put(p_entity,null );

            } else {
                // в глобальной мапе переписываем координаты
                Utils.Settings.getMap_all_entities().remove(p_entity);
                Utils.Settings.getMap_all_entities().put(p_entity, endNode.getNode());
                endNode.getPathNode().getNode().setEntity(null);
                endNode.setPathNode(null);
                endNode.getNode().setEntity(p_entity);
            }
            i_count_steps -= 1;
        }
    }
    public static void do_attack(Entity p_entity) {
        PathNode goalNode = Settings.getMap_list_goals().get(p_entity);

        int i_count_steps = ((Creature) (p_entity)).getSteps();
        int i_attack_points = ((Creature) (p_entity)).getAttack_points();

        while (i_count_steps != 0 ) {
            Entity victim =  goalNode.getNode().getEntity();

            victim.setHp(victim.getHp() - i_attack_points);
            i_count_steps -= 1;
        }
    }

    public static void create_entities() {

        int count_bears = Settings.getSpawn_bear();
        for (; count_bears != 0; count_bears--) {
            createEntity("bear");
        }
        int count_rocks = Settings.getSpawn_rock();
        for (; count_rocks != 0; count_rocks--) {
            createEntity("rock");
        }
        int count_pigs = Settings.getSpawn_pig();
        for (; count_pigs != 0; count_pigs--) {
            createEntity("pig");
        }
        int count_trees = Settings.getSpawn_tree();
        for (; count_trees != 0; count_trees--) {
            createEntity("tree");
        }
        int count_grasses = Settings.getSpawn_grass();
        for (; count_grasses != 0; count_grasses--) {
            createEntity("grass");
        }

    }
    public static void createEntity(String p_type) {
         Node [][] map = Settings.getMap_double_arr_matrix();
         int w = (int) (Math.random() * Settings.getMap_width());
         int l = (int) (Math.random() * Settings.getMap_length());

         boolean b_entity_created = false;
         switch (p_type) {
             case ("bear"):
                 if (map[w][l].getEntity() == null) {
                     Bear bear = new Bear();
                     map[w][l].setEntity(new Bear());
                     Settings.getMap_all_entities().put(bear, Settings.getMap_double_arr_matrix()[w][l]);
                     b_entity_created = true;
                 }
                 break;
             case ("rock"):
                 if (map[w][l].getEntity() == null) {
                     Rock rock = new Rock();
                     map[w][l].setEntity(rock);
                     b_entity_created = true;
                 }
                 break;
             case ("pig"):
                 if (map[w][l].getEntity() == null) {
                     Pig pig = new Pig();
                     map[w][l].setEntity(pig);
                     Settings.getMap_all_entities().put(pig, Settings.getMap_double_arr_matrix()[w][l]);
                     b_entity_created = true;
                 }
                 break;
             case ("tree"):
                 if (map[w][l].getEntity() == null) {
                     Tree tree = new Tree();
                     map[w][l].setEntity(tree);

                     b_entity_created = true;
                 }
                 break;
             case ("grass"):
                 if (map[w][l].getEntity() == null) {
                     Grass grass = new Grass();
                     map[w][l].setEntity(grass);
                     Settings.getMap_all_entities().put(grass, Settings.getMap_double_arr_matrix()[w][l]);
                     b_entity_created = true;
                 }
                 break;
         }
         if (!b_entity_created) { // Можем попасть на ячейку, в которой уже есть сущность
             createEntity(p_type);
         }
    }
}
