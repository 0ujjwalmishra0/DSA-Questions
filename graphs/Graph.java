package graphs;
import java.util.*;

public class Graph {
    private int V; // Number of vertices
    private List<List<Integer>> adjList; // Adjacency List representation

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adjList.get(v).add(w); // Add w to v's list.
//        adjList.get(w).add(v); // The graph is undirected
    }

    // Function to perform BFS on the graph starting from vertex 'v'
    void BFS(int v, boolean visited[]) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");

            for (int adj : adjList.get(v)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    // Function to handle disconnected graph
    void BFSDiconnected() {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) BFS(i, visited);
        }
    }

    void DFS(int source,boolean[] visited){
        visited[source]=true;

        for(int v: adjList.get(source)){
            if(!visited[v]){
                DFS(v,visited);
                System.out.print(source+" ");
            }
        }
    }
    void DFSDiconnected() {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) DFS(i, visited);
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(5); // Create a graph with 5 vertices
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 4);

//        System.out.println("Following is Breadth First Traversal for the given graph (starting from vertex 0):");
//        g.BFSDiconnected();
        System.out.println("NOW DFS");
        g.DFSDiconnected();
    }
}

