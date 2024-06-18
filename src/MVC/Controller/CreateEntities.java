package MVC.Controller;

import MVC.model.game_entities.*;

public class CreateEntities {
    public static void createEntities(GameMap pMap, int pBear, int pRock, int pPig, int pTree, int pGrass) {

        int countBears = pBear;
        for (; countBears != 0; countBears--) {
            createEntity("bear", pMap);
        }

        int countRocks = pRock;
        for (; countRocks != 0; countRocks--) {
            createEntity("rock", pMap);
        }

        int countPigs = pPig;
        for (; countPigs != 0; countPigs--) {
            createEntity("pig", pMap);
        }

        int countTrees = pTree;
        for (; countTrees != 0; countTrees--) {
            createEntity("tree", pMap);
        }

        int countGrasses = pGrass;
        for (; countGrasses != 0; countGrasses--) {
            createEntity("grass", pMap);
        }

    }
    private static void createEntity(String pType, GameMap pMap) {
        int w = (int) (Math.random() * pMap.getMapWidth());
        int l = (int) (Math.random() * pMap.getMapLength());

        Entity curEntity = pMap.getEntityOnNode(w, l);

        boolean bEntityCreated = false;
        switch (pType) {
            case ("bear"):
                if (curEntity == null) {
                    createEntityOnGameMap(new Bear(pMap.getNodeOnCoordinate(w,l)), pMap, w, l);
                    bEntityCreated = true;
                }
                break;
            case ("rock"):
                if (curEntity == null) {
                    pMap.setEntityOnNode(w, l, new Rock(pMap.getNodeOnCoordinate(w,l)));
                    bEntityCreated = true;
                }
                break;
            case ("pig"):
                if (curEntity == null) {
                    createEntityOnGameMap(new Pig(pMap.getNodeOnCoordinate(w,l)), pMap, w, l);
                    bEntityCreated = true;
                }
                break;
            case ("tree"):
                if (curEntity == null) {
                    pMap.setEntityOnNode(w, l, new Tree(pMap.getNodeOnCoordinate(w,l)));
                    bEntityCreated = true;
                }
                break;
            case ("grass"):
                if (curEntity == null) {
                    createEntityOnGameMap(new Grass(pMap.getNodeOnCoordinate(w,l)), pMap, w, l);
                    bEntityCreated = true;
                }
                break;
        }
        if (!bEntityCreated) { // Можем попасть на ячейку, в которой уже есть сущность, значит будем рандомить пустую ячейку
            createEntity(pType, pMap);
        }
    }

    private static void createEntityOnGameMap(Entity pEntity, GameMap pMap, int w, int l){
        pMap.setEntityOnNode(w, l, pEntity);
        pMap.addToSetAllEntities(pEntity);
    }
    public static void addEntities(GameMap pMap) {
        CreateEntities.createEntities(pMap, 0, 0, 5, 0, 20);
    }
}
