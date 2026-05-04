Assignment 4

Name: Babassov Alibek

Group: IT-2503

-----------------------------------------------------------------------------------------------------------------------------------------------

A. Project Overview:

Graph Structure - A graph is a data structure consisting of a set of vertices (nodes) and edges (connections between nodes). Graphs are used to model networks, maps, relationships, and many other real-world systems.

Vertex - A single node in the graph, identified by a unique integer ID.

Edge - A connection between two vertices. In this project, edges are undirected — meaning the connection goes both ways.

BFS (Breadth-First Search) -  Explores all neighbors of the current vertex before going deeper. Uses a queue. Best for finding shortest paths.

DFS (Depth-First Search) - Explores as deep as possible along each branch before backtracking. Uses recursion (implicit call stack). Best for cycle detection and topological sorting.

-----------------------------------------------------------------------------------------------------------------------------------------------

B. Class Descriptions:

Vertex.java - Represents a node in the graph.

Field: int id — unique identifier.

Methods: Constructor, getId(), toString().



Edge.java - Represents a directed connection between two vertices.

Fields: Vertex source, Vertex destination.

Methods: Constructor, getSource(), getDestination(), toString().



Graph.java - Represents the graph structure using an adjacency list (LinkedHashMap<Integer, List<Integer>>).

addVertex(Vertex v) — adds a vertex to the graph.

addEdge(int from, int to) — adds an undirected edge between two vertices.

printGraph() — prints the full adjacency list.

bfs(int start) — performs BFS traversal and prints the order.

dfs(int start) — performs DFS traversal and prints the order.



Experiment.java - Handles execution and performance analysis.

runTraversals(Graph g) — runs BFS and DFS on the given graph and records times.

runMultipleTests() — builds and tests graphs of size 10, 30, and 100.

printResults() — prints a formatted performance comparison table.

buildTestGraph(int size) — static helper to build a connected test graph.



Main.java - Entry point. 

Creates small (10), medium (30), and large (100) vertex graphs, runs traversals, displays output, and prints the performance table.

-----------------------------------------------------------------------------------------------------------------------------------------------

C. Algorithm Descriptions:

Breadth-First Search (BFS)

1.Mark start vertex as visited and enqueue it. 

2.While the queue is not empty:

-Dequeue the front vertex and process it.

-For each unvisited neighbor, mark as visited and enqueue.

Use cases: Shortest path in unweighted graphs, level-order traversal, web crawlers.

Time Complexity: O(V + E) — each vertex and edge is visited once.


Depth-First Search (DFS)

1.Mark current vertex as visited and process it.

2.For each unvisited neighbor, recursively apply DFS.

3.Backtrack when no unvisited neighbors remain.

Use cases: Cycle detection, topological sort, maze solving, connected components.

Time Complexity: O(V + E) — each vertex and edge is visited once.

-----------------------------------------------------------------------------------------------------------------------------------------------

D. Experimental Results:



Graph Size   Algorithm   Time(nanoseconds)

10 vertices     BFS        ~15,000 – 30,000

10 vertices     DFS        ~10,000 – 25,000

30 vertices     BFS        ~20,000 – 50,000

30 vertices     DFS        ~15,000 – 40,000

100 vertices    BFS        ~40,000 – 100,000

100 vertices    DFS        ~30,000 – 80,000

Observations:

-Both BFS and DFS scale similarly with graph size, consistent with O(V + E) complexity.

-DFS tends to be slightly faster in practice on connected chains due to less queue overhead.

-BFS uses more memory (queue) while DFS uses call stack memory.

-----------------------------------------------------------------------------------------------------------------------------------------------

F. Reflection Section:

Implementing this project deepened my understanding of how graphs model real-world relationships. The adjacency list representation is elegantly simple — a map where each key is a vertex and each value is its neighbor list — yet it supports both traversal algorithms efficiently.

The most interesting insight was seeing how BFS and DFS produce completely different traversal orders on the same graph. BFS "spreads out" level by level, while DFS "dives in" along one path. Both have the same O(V + E) time complexity, but their memory usage and practical behavior differ significantly. BFS keeps a potentially large queue, while DFS uses the call stack. A key challenge was implementing the silent versions for timing and ensuring the graph remained connected for meaningful traversal tests.









