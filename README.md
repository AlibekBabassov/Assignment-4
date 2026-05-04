Assignment 4

Name: Babassov Alibek

Group: IT-2503


A. Project Overview:

Graph Structure - A graph is a data structure consisting of a set of vertices (nodes) and edges (connections between nodes). Graphs are used to model networks, maps, relationships, and many other real-world systems.

Vertex - A single node in the graph, identified by a unique integer ID.

Edge - A connection between two vertices. In this project, edges are undirected — meaning the connection goes both ways.

BFS (Breadth-First Search) -  Explores all neighbors of the current vertex before going deeper. Uses a queue. Best for finding shortest paths.

DFS (Depth-First Search) - Explores as deep as possible along each branch before backtracking. Uses recursion (implicit call stack). Best for cycle detection and topological sorting.


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
