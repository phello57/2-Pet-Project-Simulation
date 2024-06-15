package MVC.Controller;

import MVC.Model.GameClasses.*;
import MVC.Settings;
import java.util.Iterator;


public class Actions {

    public static void initActions(GameMap pMap) {

        createEntities(pMap, Settings.SPAWN_BEAR, Settings.SPAWN_ROCK, Settings.SPAWN_PIG, Settings.SPAWN_TREE, Settings.SPAWN_GRASS);
    }
    public static void addEntities(GameMap pMap) {
        createEntities(pMap, 0, 0, 5, 0, 20);
    }
    private static void createEntities(GameMap pMap, int pBear, int pRock, int pPig, int pTree, int pGrass) {

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
        int w = (int) (Math.random() * pMap.getMAP_WIDTH());
        int l = (int) (Math.random() * pMap.getMAP_LENGTH());

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
        pMap.addToMAP_ALL_ENTITIES(pEntity);
    }

    public static void turnActions(GameMap pMap) {
        int countPigs = 0;
        for (Iterator<Entity> iterator =
             pMap.getMAP_ALL_ENTITIES().iterator(); iterator.hasNext(); )
        {
            Entity entity = iterator.next();

            if (entity.getHp() <= 0 ) {
                iterator.remove();
                entity.getCurNode().setEntity(null);
                continue;
            }

            if (!entity.getArrGoals().isEmpty()) {
                ((Creature) entity).makeMove();
            }
            if ("class MVC.Model.GameClasses.Pig".equals(entity.getClass().toString())) {
                countPigs++;
            }
        }

        if (countPigs == 0 ) {
            addEntities(pMap);
        }
    }
}
