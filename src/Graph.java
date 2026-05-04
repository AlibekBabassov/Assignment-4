import java.util.*;

public class Graph {
    // Maps each vertex to its list of adjacent vertices
    private Map<Integer, List<Integer>> adjacencyList;
    // Maps vertex id to Vertex object
    private Map<Integer, Vertex> vertices;

    public Graph() {
        adjacencyList = new LinkedHashMap<>();
        vertices = new LinkedHashMap<>();
    }

    //Adds a vertex to the graph. If vertex already exists, does nothing.
    public void addVertex(Vertex v) {
        if (!adjacencyList.containsKey(v.getId())) {
            adjacencyList.put(v.getId(), new ArrayList<>());
            vertices.put(v.getId(), v);
        }
    }

    //Adds an undirected edge between vertex 'from' and vertex 'to'.
    // Automatically creates vertices if they don't exist.
    public void addEdge(int from, int to) {
        // Auto-create vertices if not present
        if (!adjacencyList.containsKey(from)) {
            addVertex(new Vertex(from));
        }
        if (!adjacencyList.containsKey(to)) {
            addVertex(new Vertex(to));
        }

        // Add undirected edge (both directions)
        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
    }

    //Prints the adjacency list representation of the graph.
    public void printGraph() {
        System.out.println("Graph Adjacency List:");
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    //Returns the number of vertices in the graph.
    public int getVertexCount() {
        return adjacencyList.size();
    }

    //Returns the set of all vertex IDs in the graph.
    public Set<Integer> getVertexIds() {
        return adjacencyList.keySet();
    }

    //Performs Breadth-First Search (BFS) starting from the given vertex.
    //BFS explores all neighbors at the current depth before moving deeper.
    //Time Complexity: O(V + E) where V = vertices, E = edges.
    public void bfs(int start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("BFS: Start vertex " + start + " not found.");
            return;
        }

        // Track visited vertices to avoid revisiting
        Set<Integer> visited = new LinkedHashSet<>();
        // Queue for BFS - processes nodes level by level
        Queue<Integer> queue = new LinkedList<>();

        // Initialize with the start vertex
        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal from " + start + ": ");

        while (!queue.isEmpty()) {
            // Dequeue the front vertex
            int current = queue.poll();
            System.out.print(current + " ");

            // Enqueue all unvisited neighbors
            for (int neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }


    //Performs Depth-First Search (DFS) starting from the given vertex.
    //DFS explores as far as possible along each branch before backtracking.
    //Time Complexity: O(V + E) where V = vertices, E = edges.
    public void dfs(int start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("DFS: Start vertex " + start + " not found.");
            return;
        }

        Set<Integer> visited = new LinkedHashSet<>();
        System.out.print("DFS Traversal from " + start + ": ");
        // Use recursive helper to perform DFS
        dfsHelper(start, visited);
        System.out.println();
    }


    //Recursive helper method for DFS traversal.
    //Visits the current vertex and recursively explores unvisited neighbors.
    private void dfsHelper(int current, Set<Integer> visited) {
        // Mark this vertex as visited and print it
        visited.add(current);
        System.out.print(current + " ");

        // Recursively visit each unvisited neighbor
        for (int neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}
