package graphs;

import java.util.*;

public class KruskalAlgo {
    static class Edge implements Comparable<Edge>{
        int node;
        int adjNode;
        int weight;
        Edge(int u, int v, int weight){
            this.node= u;
            this.adjNode= v;
            this.weight= weight;
        }
        @Override
        public int compareTo(Edge e) {
            return this.weight- e.weight;
        }
    }
    public static void main(String[] args) {
        
    }

     int spanningTree(int V, int E, int[][] edges){

        ArrayList<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int node = edges[i][0];
            int adjNode = edges[i][1];
            int weight = edges[i][2];
            Edge temp = new Edge(node, adjNode, weight);
            edgeList.add(temp);
        }

         Collections.sort(edgeList);
         int mstWeight=0;
         DisjointSet disjointSet = new DisjointSet(V);
         for (int i = 0; i < edgeList.size(); i++) {
             int node = edgeList.get(i).node;
             int adjNode = edgeList.get(i).adjNode;
             int weight = edgeList.get(i).weight;

             //if parent not same, means diff component or disjoint
             if(disjointSet.findUParent(node)!= disjointSet.findUParent(adjNode)){
                 mstWeight+= weight;
                 disjointSet.unionBySize(node,adjNode);
             }
         }
         return mstWeight;


    }
}
