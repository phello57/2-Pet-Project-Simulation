package MVC.model.game_entities;

import MVC.model.classes_for_bfs.Edge;
import MVC.model.classes_for_bfs.Node;
import java.util.HashSet;

public class GameMap {
    public GameMap(int w, int l) {
        this.MAP_LENGTH = l;
        this.MAP_WIDTH = w;
        this.dArrGameMap = new Node[w][l];
        createMap();
    }
    private final int MAP_LENGTH;
    private final int MAP_WIDTH;
    private final Node[][] dArrGameMap;
    private final HashSet<Entity> setAllEntities = new HashSet<>();

    public HashSet<Entity> getSetAllEntities() {return setAllEntities;}
    public void addToSetAllEntities(Entity entity) {
        this.setAllEntities.add(entity);
    }
    public Node getNodeOnCoordinate(int width, int length) {
        return dArrGameMap[width][length];
    }
    public int getMapLength() {
        return MAP_LENGTH;
    }
    public int getMapWidth() {
        return MAP_WIDTH;
    }
    public void setEntityOnNode(int w, int l, Entity entity) {dArrGameMap[w][l].setEntity(entity);}
    public Entity getEntityOnNode(int w, int l) {
        return dArrGameMap[w][l].getEntity();
    }

    private void createMap() {
        for (int wid = 0; wid < MAP_WIDTH; wid++) {  // count []
            for (int len = 0; len < MAP_LENGTH; len++) { // index
                createMapCell(wid, len, new Node());
            }
        }
        wrapperCreateEdges();
    }

    private void createMapCell(int pWidth, int pLength, Node pNode) {
        dArrGameMap[pWidth][pLength] = pNode;
    }

    // Свяжем каждую клетку с 8 клетками вокруг
    private void wrapperCreateEdges() {

        for (int wid = 0; wid < MAP_WIDTH; wid++) {  // count []
            for (int len = 0; len < MAP_LENGTH; len++) { // index
                createEdges(wid
                        , len
                        , dArrGameMap[wid][len]);
            }
        }
    }

    private  void create(int pW, int pL, Node pParentNode) {
        // Проверим не вышли ли за пределы массива
        if ( (pL >= 0 && MAP_LENGTH > pL)
                && (pW >= 0 && MAP_WIDTH > pW)
        ) {
            pParentNode.addEdge(new Edge(dArrGameMap[pW][pL]));
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
    public Node[][] getdArrGameMap() {
        return this.dArrGameMap;
    }
}
