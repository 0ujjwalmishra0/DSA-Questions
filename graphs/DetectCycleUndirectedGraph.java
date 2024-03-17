package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class GraphNode{
    int current;
    int parent;
    GraphNode(int current,int parent){
        this.current=current;
        this.parent=parent;
    }
}
public class DetectCycleUndirectedGraph {

    public boolean isCycle(int source, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited= new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if(!visited[i]){
//                boolean isCycle= detectCycleBFS(adj,visited,i);
                boolean isCycle= detectCycleDFS(adj,visited,i,-1);
                if(isCycle) return true;
            }
        }
        return false;
    }

    private boolean detectCycleBFS(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int source){
        visited[source]=true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{source, -1});
        while(!queue.isEmpty()){
            int[] currentPair = queue.poll(); // Directly poll here
            int currentNode= currentPair[0];
            int parentNode= currentPair[1];
            for(int neighbourNode: adj.get(currentNode)){
                if(!visited[neighbourNode]){
                    visited[neighbourNode]=true;
                    queue.add(new int[]{neighbourNode,currentNode});
                }else if(parentNode!=neighbourNode){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycleDFS(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int source,int parent){
        visited[source]= true;
        for(int node: adj.get(source)){
            if(!visited[node]){
                if(detectCycleDFS(adj,visited,node,source)){
                    return true;
                }
            }else if(parent!=node){
                return true;
            }
        }
        return false;
    }



}
