package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgo {
    public static void main(String[] args) {

    }

    private static void calculateIndegree(ArrayList<ArrayList<Integer>> adj,int[] indegree){
        for(ArrayList<Integer> rows: adj){
            for(Integer node: rows){
                indegree[node]++;
            }
        }
    }

//    private static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
//
//
//    }

    private static void BFS(int V, ArrayList<ArrayList<Integer>>adj,boolean[] visited) {
        int[] indegree = new int[V];
        calculateIndegree(adj, indegree);
        Queue<Integer> queue= new LinkedList<>();
        for(int node: indegree){
            //add all node whose indegree is 0
            if(node==0){
                queue.add(node);
            }
        }


        while (!queue.isEmpty()) {
            int zeroIndegreeNode = queue.poll();
            for(int node: adj.get(zeroIndegreeNode)){
                if(!visited[node]){
                    visited[node]=true;
                    indegree[node]--;
                    if(indegree[node]==0) {
                        queue.add(node);
                    }
                }
            }
        }
        
    }
}
