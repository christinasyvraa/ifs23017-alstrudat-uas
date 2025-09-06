package del.ifs23017;

import java.util.ArrayList;
import java.util.List;

public class GraphHelper {
    public static void printGraph(Graph graph, List<String> orderedVertices) {
        for (String place : orderedVertices) {
            System.out.print(place + " -> ");
            ArrayList<String> connections = new ArrayList<>();
            for (PlaceDistance pd : graph.adjList.get(place)) {
                connections.add(pd.targetPlace + " (" + pd.distance + "km)");
            }
            System.out.println(String.join(", ", connections));
        }
    }
}
