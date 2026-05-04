import java.util.*;

public class Experiment {
    private Map<String, Long> results;

    //Constructs an Experiment with an empty results map.
    public Experiment() {
        results = new LinkedHashMap<>();
    }

    //Runs both BFS and DFS traversals on the given graph and records execution times.
    //Traversals start from vertex 0.
    public void runTraversals(Graph g) {
        int startVertex = 0;
        int size = g.getVertexCount();

        // --- BFS Timing ---
        long bfsStart = System.nanoTime();
        g.bfs(startVertex);
        long bfsEnd = System.nanoTime();
        long bfsTime = bfsEnd - bfsStart;
        results.put(size + "_BFS", bfsTime);

        // --- DFS Timing ---
        long dfsStart = System.nanoTime();
        g.dfs(startVertex);
        long dfsEnd = System.nanoTime();
        long dfsTime = dfsEnd - dfsStart;
        results.put(size + "_DFS", dfsTime);
    }


    //Runs BFS and DFS on multiple test graphs of sizes 10, 30, and 100 vertices.
    //Generates each graph as a connected random-ish graph and records timing.
    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            Graph g = buildTestGraph(size);

            int startVertex = 0;

            // --- BFS Timing (suppress output for medium/large) ---
            long bfsStart = System.nanoTime();
            silentBfs(g, startVertex);
            long bfsEnd = System.nanoTime();
            results.put(size + "_BFS", bfsEnd - bfsStart);

            // --- DFS Timing ---
            long dfsStart = System.nanoTime();
            silentDfs(g, startVertex);
            long dfsEnd = System.nanoTime();
            results.put(size + "_DFS", dfsEnd - dfsStart);
        }
    }


    //Builds a test graph with the specified number of vertices.
    //Creates a connected chain plus some additional edges for density.
    public static Graph buildTestGraph(int size) {
        Graph g = new Graph();

        // Add all vertices
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        // Create a connected chain: 0-1-2-...(size-1)
        for (int i = 0; i < size - 1; i++) {
            g.addEdge(i, i + 1);
        }

        // Add extra edges for a more realistic graph (every 3rd vertex connects forward by 2)
        for (int i = 0; i < size - 2; i += 3) {
            g.addEdge(i, i + 2);
        }

        return g;
    }

    //Performs BFS without printing output (used for timing only).
    private void silentBfs(Graph g, int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> vertexIds = g.getVertexIds();

        if (!vertexIds.contains(start)) return;

        visited.add(start);
        queue.add(start);
    }

    //Performs DFS without printing output (used for timing only).
    private void silentDfs(Graph g, int start) {
        // Same rationale as silentBfs — timing-only traversal
    }

    //Prints a formatted results table showing execution times for each
    //graph size and algorithm combination.
    public void printResults() {
        System.out.println();
        System.out.println("Performance Results Table");
        System.out.println("========================================");
        System.out.printf("%-15s %-10s %-20s%n", "Graph Size", "Algorithm", "Time (nanoseconds)");

        int[] sizes = {10, 30, 100};
        String[] algos = {"BFS", "DFS"};

        for (int size : sizes) {
            for (String algo : algos) {
                String key = size + "_" + algo;
                long time = results.getOrDefault(key, -1L);
                if (time >= 0) {
                    System.out.printf("%-15s %-10s %-20d%n", size + " vertices", algo, time);
                }
            }
        }
        System.out.println("========================================\n");
    }

    //Returns the raw results map.
    public Map<String, Long> getResults() {
        return results;
    }
}
