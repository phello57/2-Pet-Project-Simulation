package MVC.Model.GameClasses;

import MVC.Model.UtilsClasses.Edge;
import MVC.Model.UtilsClasses.Node;
import java.util.HashSet;

public class GameMap {
    public GameMap(int w, int l) {
        this.MAP_LENGTH = l;
        this.MAP_WIDTH = w;
        this.MAP_GAME_MAP = new Node[w][l];
        createMap();
    }
    private final int MAP_LENGTH;
    private final int MAP_WIDTH;
    private final Node[][] MAP_GAME_MAP;
    private final HashSet<Entity> MAP_ALL_ENTITIES = new HashSet<>();



    public HashSet<Entity> getMAP_ALL_ENTITIES() {return MAP_ALL_ENTITIES;}
    public void addToMAP_ALL_ENTITIES(Entity entity) {
        this.MAP_ALL_ENTITIES.add(entity);
    }
    public Node getNodeOnCoordinate(int w, int l) {
        return MAP_GAME_MAP[w][l];
    }
    public int getMAP_LENGTH() {
        return MAP_LENGTH;
    }
    public int getMAP_WIDTH() {
        return MAP_WIDTH;
    }
    public void setEntityOnNode(int w, int l, Entity entity) {MAP_GAME_MAP[w][l].setEntity(entity);}
    public Entity getEntityOnNode(int w, int l) {
        return MAP_GAME_MAP[w][l].getEntity();
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
        this.MAP_GAME_MAP[pWidth][pLength] = pNode;
    }

    // Свяжем каждую клетку с 8 клетками вокруг
    private void wrapperCreateEdges() {

        for (int wid = 0; wid < MAP_WIDTH; wid++) {  // count []
            for (int len = 0; len < MAP_LENGTH; len++) { // index
                createEdges(wid
                        , len
                        , MAP_GAME_MAP[wid][len]);
            }
        }
    }

    private  void create(int pW, int pL, Node pParentNode) {
        // Проверим не вышли ли за пределы массива
        if ( (pL >= 0 && MAP_LENGTH > pL)
                && (pW >= 0 && MAP_WIDTH > pW)
        ) {
            pParentNode.addEdge(new Edge(MAP_GAME_MAP[pW][pL]));
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
    public Node[][] getMapGame() {
        return this.MAP_GAME_MAP;
    }
}
