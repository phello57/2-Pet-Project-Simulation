package Utils;
import DefaultClasses.*;
import GameClasses.*;

public class Map {

    public static void createMap() {
        int sWidth = Settings.getMapWidth();
        int sLength = Settings.getMapLength();

        for (int wid = 0; wid < sWidth; wid++) {  // count []
            for (int len = 0; len < sLength; len++) { // index
                Settings.setNodeMapGame(wid, len, new Node());
            }
        }
        wrapperCreateEdges();
    }

    // Свяжем каждую клетку с 8 клетками вокруг
    private static void wrapperCreateEdges() {
        int sWidth = Settings.getMapWidth();
        int sLength = Settings.getMapLength();

        for (int wid = 0; wid < sWidth; wid++) {  // count []
            for (int len = 0; len < sLength; len++) { // index
                //System.out.println(wid+"_"+len);
                createEdges(wid
                          , len
                          , Settings.getNodeOnCoordinate(wid, len) );
            }
        }
    }

    private static void create(int pW, int pL, Node pParentNode) {
        // Проверим не вышли ли за пределы массива
        if ( (pL >= 0 && Settings.getMapLength() > pL)
             && (pW >= 0 && Settings.getMapWidth() > pW)
        ) {
            pParentNode.addEdge(new Edge(Settings.getNodeOnCoordinate(pW, pL)));
            //System.out.println("from: "+parent_node.getW()+"_"+parent_node.getL()+" to "+p_w+"_"+p_l);
        }
    }

    private static void createEdges(int pW, int pL, Node pNode) {

        create(pW - 1, pL - 1 , pNode); // верх лево
        create(pW - 1, pL         , pNode);   // центр верх
        create(pW - 1, pL + 1 , pNode); // верх право
        create(pW, pL - 1          , pNode);     // центр лево
        create(pW, pL + 1           , pNode); // центр право
        create(pW + 1, pL - 1  , pNode); // лево низ
        create(pW + 1, pL          , pNode); // центр низ
        create(pW + 1, pL+ 1   , pNode); // право низ

    }

    public static void doSteps(Entity pEntity) {
        PathNode goalNode = Settings.getMapListGoals().get(pEntity);

        int iCountSteps = ((Creature) (pEntity)).getSteps();


        // переписать эту шизофрению на связный список

        while (iCountSteps != 0 ) {
            PathNode endNode = goalNode;

            // нужно в endNode дойти до начального узла, что бы свичнуть сущность с первого узла на второй
            try {
                while (endNode.getPathNode().getPathNode().getNode() != null) {
                    endNode = endNode.getPathNode();
                    //System.out.println(goalNode.getNode().getW()+"_"+goalNode.getNode().getL());
                }
            } catch (NullPointerException e) {}

            if (endNode.getNode().getEntity() != null) { // если в первом узле кто то есть, то удаляем путь, надо искать вновь
                Settings.addToMapRemoveGoals(pEntity,null );

            } else {
                // в глобальной мапе переписываем координаты
                Settings.removeFromMapAllEntities(pEntity);
                Settings.addToMapAllEntities(pEntity, endNode.getNode() );

                // обнуляем во втором узле ссылку
                // даем второму узлу текущую сущность - перемещаем её по родителям
                endNode.getPathNode().getNode().setEntity(null);
                endNode.setPathNode(null);
                endNode.getNode().setEntity(pEntity);
            }
            iCountSteps -= 1;
        }
    }
    public static void doAttack(Entity pEntity) {
        PathNode goalNode = Settings.getMapListGoals().get(pEntity);

        int iCountSteps = ((Creature) pEntity ).getSteps();
        int iAttackPoints = ((Creature) pEntity ).getAttackPoints();

        while (iCountSteps != 0 ) {
            Entity victim =  goalNode.getNode().getEntity();

            victim.setHp(victim.getHp() - iAttackPoints);
            iCountSteps -= 1;
        }
    }

    public static void createEntities() {

        int countBears = Settings.getSpawnBear();
        for (; countBears != 0; countBears--) {
            createEntity("bear");
        }
        int countRocks = Settings.getSpawnRock();
        for (; countRocks != 0; countRocks--) {
            createEntity("rock");
        }
        int countPigs = Settings.getSpawnPig();
        for (; countPigs != 0; countPigs--) {
            createEntity("pig");
        }
        int countTrees = Settings.getSpawnTree();
        for (; countTrees != 0; countTrees--) {
            createEntity("tree");
        }
        int countGrasses = Settings.getSpawnGrass();
        for (; countGrasses != 0; countGrasses--) {
            createEntity("grass");
        }

    }
    public static void createEntity(String pType) {
         Node [][] map = Settings.getMapDoubleArrMatrix();
         int w = (int) (Math.random() * Settings.getMapWidth());
         int l = (int) (Math.random() * Settings.getMapLength());

         boolean bEntityCreated = false;
         switch (pType) {
             case ("bear"):
                 if (map[w][l].getEntity() == null) {
                     Bear bear = new Bear();
                     map[w][l].setEntity(new Bear());
                     Settings.addToMapAllEntities(bear, Settings.getNodeOnCoordinate(w, l));
                     bEntityCreated = true;
                 }
                 break;
             case ("rock"):
                 if (map[w][l].getEntity() == null) {
                     Rock rock = new Rock();
                     map[w][l].setEntity(rock);
                     bEntityCreated = true;
                 }
                 break;
             case ("pig"):
                 if (map[w][l].getEntity() == null) {
                     Pig pig = new Pig();
                     map[w][l].setEntity(pig);
                     Settings.addToMapAllEntities(pig, Settings.getNodeOnCoordinate(w, l));
                     bEntityCreated = true;
                 }
                 break;
             case ("tree"):
                 if (map[w][l].getEntity() == null) {
                     Tree tree = new Tree();
                     map[w][l].setEntity(tree);

                     bEntityCreated = true;
                 }
                 break;
             case ("grass"):
                 if (map[w][l].getEntity() == null) {
                     Grass grass = new Grass();
                     map[w][l].setEntity(grass);
                     Settings.addToMapAllEntities(grass, Settings.getNodeOnCoordinate(w, l));

                     bEntityCreated = true;
                 }
                 break;
         }
         if (!bEntityCreated) { // Можем попасть на ячейку, в которой уже есть сущность, значит будем рандомить пустую ячейку
             createEntity(pType);
         }
    }
}
