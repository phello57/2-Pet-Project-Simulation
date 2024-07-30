package game.model.game_entities;

import game.model.BFS.Edge;
import game.model.BFS.Node;
import java.util.HashSet;

public class GameMap {
    public GameMap(int w, int l) {
        this.MAP_LENGTH = l;
        this.MAP_WIDTH = w;
        this.GAME_MAP = new Node[w][l];
        createMap();
    }

    public final int MAP_LENGTH;

    public final int MAP_WIDTH;

    private final Node[][] GAME_MAP;

    private final HashSet<Entity> entitiesWithHP = new HashSet<>();

    public HashSet<Entity> getSetEntitiesWithHP() {return entitiesWithHP;}

    public void addToMapEntity(Entity entity, Node node) {

        node.setEntity(entity);
        if (entity.getClass().getSimpleName().equals("Pig")
                || entity.getClass().getSimpleName().equals("Bear")
                || entity.getClass().getSimpleName().equals("Grass"))
            this.entitiesWithHP.add(entity);

    }

    public Node getNodeOnCoordinate(int width, int length) {
        return GAME_MAP[width][length];
    }

    private void createMapCell(int pWidth, int pLength, Node pNode) {
        GAME_MAP[pWidth][pLength] = pNode;
    }


    private void createMap() {
        for (int wid = 0; wid < MAP_WIDTH; wid++) {  // count []
            for (int len = 0; len < MAP_LENGTH; len++) { // index
                createMapCell(wid, len, new Node());
            }
        }
        wrapperCreateEdges();
    }

    // Свяжем каждую клетку с 8 клетками вокруг
    private void wrapperCreateEdges() {

        for (int wid = 0; wid < MAP_WIDTH; wid++) {  // count []
            for (int len = 0; len < MAP_LENGTH; len++) { // index
                createEdges(wid
                        , len
                        , GAME_MAP[wid][len]);
            }
        }
    }


    private  void create(int pW, int pL, Node pParentNode) {
        // Проверим не вышли ли за пределы массива
        if ( (pL >= 0 && MAP_LENGTH > pL)
                && (pW >= 0 && MAP_WIDTH > pW)
        ) {
            pParentNode.addEdge(new Edge(GAME_MAP[pW][pL]));
        }
    }

    private void createEdges(int pW, int pL, Node pNode) {

        create(pW - 1, pL - 1 , pNode); // верх лево
        create(pW - 1, pL         , pNode);   // центр верх
        create(pW - 1, pL + 1 , pNode); // верх право
        create(pW, pL - 1          , pNode);     // центр лево
        create(pW, pL + 1           , pNode); // центр право
        create(pW + 1, pL - 1  , pNode); // лево низ
        create(pW + 1, pL          , pNode); // центр низ
        create(pW + 1, pL+ 1   , pNode); // право низ
    }

    public Node[][] getGAME_MAP() {
        return this.GAME_MAP;
    }
}
