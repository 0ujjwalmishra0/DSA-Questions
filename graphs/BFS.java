package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from vertex 0 (assuming the graph is connected)
        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int source = queue.poll();
            ans.add(source);
            for (int v : adj.get(source)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        return ans;
    }


}
