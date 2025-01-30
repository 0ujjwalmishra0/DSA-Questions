package graphs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-eventual-safe-states/description/
public class SafeStates {
    public static void main(String[] args) {

    }
    private List<Integer> eventualSafeNodes(int V,List<List<Integer>> adj){
        int n= adj.size();
        boolean[] visited= new boolean[n];
        boolean[] visitedPath= new boolean[n];
        boolean[] checkNodes= new boolean[n];
        ArrayList<Integer> safeNodes= new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                detectCycleDFS(adj,visited,visitedPath,checkNodes,i);
            }
        }

        for (int i = 0; i < n; i++) {
            if(checkNodes[i]){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean detectCycleDFS(List<List<Integer>> adj,boolean[] visited,
                                   boolean[] visitedPath, boolean[] checkNodes,int source){
        visited[source]=true;
        visitedPath[source]=true;
        for(int node: adj.get(source)){
            if(!visited[node]){
                visited[node]=true;
                visitedPath[node]=true;
                if(detectCycleDFS(adj,visited,visitedPath,checkNodes,node)){
                    return true;
                }
            }else if(visitedPath[node]){
                return true;
            }
        }
        visitedPath[source]=false;
        checkNodes[source]=true;
        return false;
    }
}
