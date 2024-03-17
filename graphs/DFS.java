package graphs;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited=new boolean[V];
        return DFS(0,adj,visited,new ArrayList<>());
    }

    private ArrayList<Integer> DFS(int source, ArrayList<ArrayList<Integer>> adj,boolean[] visited,ArrayList<Integer> ans){
        visited[source]=true;
        ans.add(source);
        for(int v: adj.get(source)){
            if(!visited[v]) {
                DFS(v, adj, visited, ans);
            }
        }
        return ans;
    }
}
