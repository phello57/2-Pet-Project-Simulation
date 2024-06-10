package MVC;
import MVC.Controller.Controller;
import MVC.Model.Model;
import MVC.Model.GameClasses.*;
import MVC.Model.UtilsClasses.Edge;
import MVC.Model.UtilsClasses.Node;

// Создание карты и создание сущностей на карте
public class View {

    public static void createMap() {
        int sWidth = Model.getMapWidth();
        int sLength = Model.getMapLength();

        for (int wid = 0; wid < sWidth; wid++) {  // count []
            for (int len = 0; len < sLength; len++) { // index
                Controller.createMapCell(wid, len, new Node());
            }
        }
        wrapperCreateEdges();
    }

    // Свяжем каждую клетку с 8 клетками вокруг
    private static void wrapperCreateEdges() {
        int sWidth = Model.getMapWidth();
        int sLength = Model.getMapLength();

        for (int wid = 0; wid < sWidth; wid++) {  // count []
            for (int len = 0; len < sLength; len++) { // index
                //System.out.println(wid+"_"+len);
                createEdges(wid
                          , len
                          , Model.getNodeOnCoordinate(wid, len) );
            }
        }
    }

    private static void create(int pW, int pL, Node pParentNode) {
        // Проверим не вышли ли за пределы массива
        if ( (pL >= 0 && Model.getMapLength() > pL)
             && (pW >= 0 && Model.getMapWidth() > pW)
        ) {
            pParentNode.addEdge(new Edge(Model.getNodeOnCoordinate(pW, pL)));
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

    public static void createEntities() {

        int countBears = Model.getSpawnBear();
        for (; countBears != 0; countBears--) {
            createEntity("bear");
        }
        int countRocks = Model.getSpawnRock();
        for (; countRocks != 0; countRocks--) {
            createEntity("rock");
        }
        int countPigs = Model.getSpawnPig();
        for (; countPigs != 0; countPigs--) {
            createEntity("pig");
        }
        int countTrees = Model.getSpawnTree();
        for (; countTrees != 0; countTrees--) {
            createEntity("tree");
        }
        int countGrasses = Model.getSpawnGrass();
        for (; countGrasses != 0; countGrasses--) {
            createEntity("grass");
        }

    }
    public static void createEntity(String pType) {
         int w = (int) (Math.random() * Model.getMapWidth());
         int l = (int) (Math.random() * Model.getMapLength());

         Node curNode = Model.getNodeOnCoordinate(w, l);
         Entity curEntity = curNode.getEntity();

         boolean bEntityCreated = false;
         switch (pType) {
             case ("bear"):
                 if (curEntity == null) {
                     Controller.createEntityOnGameMap(new Bear(), curNode);
                     bEntityCreated = true;
                 }
                 break;
             case ("rock"):
                 if (curEntity == null) {
                     curNode.setEntity(new Rock());
                     bEntityCreated = true;
                 }
                 break;
             case ("pig"):
                 if (curEntity == null) {
                     Controller.createEntityOnGameMap(new Pig(), curNode);
                     bEntityCreated = true;
                 }
                 break;
             case ("tree"):
                 if (curEntity == null) {
                     curNode.setEntity(new Tree());
                     bEntityCreated = true;
                 }
                 break;
             case ("grass"):
                 if (curEntity == null) {
                     Controller.createEntityOnGameMap(new Grass(), curNode);
                     bEntityCreated = true;
                 }
                 break;
         }
         if (!bEntityCreated) { // Можем попасть на ячейку, в которой уже есть сущность, значит будем рандомить пустую ячейку
             createEntity(pType);
         }
    }
}
