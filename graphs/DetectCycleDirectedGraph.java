package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedGraph {
    public static void main(String[] args) {

    }

    private boolean isCycle(ArrayList<ArrayList<Integer>> adj){
        int n= adj.size();
        boolean[] visited = new boolean[n];
        boolean[] visitedPath = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                if(detectCycleDFS(adj,visited,visitedPath,i)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycleDFS(ArrayList<ArrayList<Integer>> adj,boolean[] visited, boolean[] visitedPath,int source){
        visited[source]=true;
        visitedPath[source]=true;

        for(int node: adj.get(source)){
            //when the node is not visited
            if(!visited[node]){
                if(detectCycleDFS(adj,visited,visitedPath,node)){
                    return true;
                }
            }
            //node visited but it has to be visited on same path
            else if(visitedPath[node]){
                return true;
            }
        }
        visitedPath[source]=false;
        return false;
    }

    private boolean detectCycleBFS(ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] visitedPath,int source){
        visited[source]=true;
        visitedPath[source]=true;
        Queue<Integer>  queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int curr= queue.poll();
            for(int node: adj.get(curr)){
                if(!visited[node]){
                    queue.add(node);
                    visited[node]=true;
                    visitedPath[node]=true;
                }
            }
        }
    }

}
