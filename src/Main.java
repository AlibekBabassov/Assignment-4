public class Main {
    public static void main() {
        // PART 1: Small Graph Demo (10 vertices) — show traversal order
        System.out.println("PART 1: Small Graph Demo (10 vertices)");
        Graph smallGraph = new Graph();

        // Add 10 vertices
        for (int i = 0; i < 10; i++) {
            smallGraph.addVertex(new Vertex(i));
        }

        // Add edges (undirected)
        smallGraph.addEdge(0, 1);
        smallGraph.addEdge(0, 2);
        smallGraph.addEdge(1, 3);
        smallGraph.addEdge(1, 4);
        smallGraph.addEdge(2, 5);
        smallGraph.addEdge(2, 6);
        smallGraph.addEdge(3, 7);
        smallGraph.addEdge(4, 8);
        smallGraph.addEdge(5, 9);

        // Print graph structure
        smallGraph.printGraph();
        System.out.println();

        // Run and time BFS
        System.out.println("--- BFS ---");
        long bfsStart = System.nanoTime();
        smallGraph.bfs(0);
        long bfsEnd = System.nanoTime();
        System.out.println("BFS execution time: " + (bfsEnd - bfsStart) + " ns");
        System.out.println();

        // Run and time DFS
        System.out.println("--- DFS ---");
        long dfsStart = System.nanoTime();
        smallGraph.dfs(0);
        long dfsEnd = System.nanoTime();
        System.out.println("DFS execution time: " + (dfsEnd - dfsStart) + " ns");
        System.out.println();

        // PART 2: Medium Graph Demo (30 vertices)
        System.out.println("PART 2: Medium Graph Demo (30 vertices)");
        Graph mediumGraph = Experiment.buildTestGraph(30);

        System.out.println("--- BFS ---");
        long bfsStart2 = System.nanoTime();
        mediumGraph.bfs(0);
        long bfsEnd2 = System.nanoTime();
        System.out.println("BFS execution time: " + (bfsEnd2 - bfsStart2) + " ns");
        System.out.println();

        System.out.println("--- DFS ---");
        long dfsStart2 = System.nanoTime();
        mediumGraph.dfs(0);
        long dfsEnd2 = System.nanoTime();
        System.out.println("DFS execution time: " + (dfsEnd2 - dfsStart2) + " ns");
        System.out.println();

        // PART 3: Large Graph Demo (100 vertices)
        System.out.println("PART 3: Large Graph Demo (100 vertices)");
        Graph largeGraph = Experiment.buildTestGraph(100);

        System.out.println("--- BFS ---");
        long bfsStart3 = System.nanoTime();
        largeGraph.bfs(0);
        long bfsEnd3 = System.nanoTime();
        System.out.println("BFS execution time: " + (bfsEnd3 - bfsStart3) + " ns");
        System.out.println();

        System.out.println("--- DFS ---");
        long dfsStart3 = System.nanoTime();
        largeGraph.dfs(0);
        long dfsEnd3 = System.nanoTime();
        System.out.println("DFS execution time: " + (dfsEnd3 - dfsStart3) + " ns");
        System.out.println();

        // PART 4: Experiment — Performance Comparison Table
        System.out.println("PART 4: Experiment — Performance Comparison");

        // Store manually measured times into Experiment for the results table
        Experiment experiment = new Experiment();

        // Build fresh graphs and time them properly
        int[] sizes = {10, 30, 100};
        for (int size : sizes) {
            Graph g = Experiment.buildTestGraph(size);

            // Warm up JIT
            g.bfs(0);
            g.dfs(0);

            // Timed run
            long b1 = System.nanoTime();
            g.bfs(0);
            long b2 = System.nanoTime();

            long d1 = System.nanoTime();
            g.dfs(0);
            long d2 = System.nanoTime();

            experiment.getResults().put(size + "_BFS", b2 - b1);
            experiment.getResults().put(size + "_DFS", d2 - d1);
        }

        experiment.printResults();
    }
}
