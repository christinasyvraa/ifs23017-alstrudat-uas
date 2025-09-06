package del.ifs23017;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Graph {
    public LinkedHashMap<String, ArrayList<PlaceDistance>> adjList = new LinkedHashMap<>();

    public boolean addVertex(String vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2, double distance) {
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            adjList.get(vertex1).add(new PlaceDistance(vertex2, distance));
            adjList.get(vertex2).add(new PlaceDistance(vertex1, distance));
            return true;
        }
        return false;
    }
}
