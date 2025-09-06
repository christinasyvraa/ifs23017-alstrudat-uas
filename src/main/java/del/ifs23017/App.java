package del.ifs23017;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        // Baca dan tambahkan semua vertex dulu agar urutan LinkedHashMap tetap
        String vertexLine = scanner.nextLine();
        String[] vertices = vertexLine.split(",");
        List<String> orderedVertices = new ArrayList<>();
        for (String v : vertices) {
            String trimmed = v.trim();
            graph.addVertex(trimmed);
            orderedVertices.add(trimmed);  // Simpan urutan input
        }

        // Baca dan tambahkan semua edge
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("FINISH")) break;

            String[] parts = line.split("=>");
            String source = parts[0].trim();
            String[] targets = parts[1].split(",");

            for (String targetInfo : targets) {
                String[] pair = targetInfo.trim().split(":");
                String target = pair[0].trim();
                double distance = Double.parseDouble(pair[1].trim());
                graph.addEdge(source, target, distance);
            }
        }

        // Cetak hasil
        System.out.println("Peta Jalur Wilayah:");
        GraphHelper.printGraph(graph, orderedVertices);  // kirim urutan input
    }
}
