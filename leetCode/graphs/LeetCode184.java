package leetCode.graphs;

import graphs.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;

public class LeetCode184 {

    public int minCostConnectPoints(int[][] points) {
        int v = points.length;
        DisjointSet ds = new DisjointSet(v);
        ArrayList<Edge> edges= new ArrayList<Edge>();
        for(int i=0;i<v;i++){
            for(int j=i+1;j<v;j++){
                int xi= points[i][0],  yi= points[i][1];
                int xj= points[j][0],  yj= points[j][1];
                int cost= Math.abs(xi-xj) + Math.abs(yi-yj);

                edges.add(new Edge(i,j,cost));
            }
        }
        Collections.sort(edges);
        int mstWeight=0;
        for(int i=0;i< edges.size();i++){
            int node= edges.get(i).node;
            int adjNode= edges.get(i).adjNode;
            int weight= edges.get(i).weight;

            if (ds.findUParent(node)!=ds.findUParent(adjNode)){
                ds.unionBySize(node,adjNode);
                mstWeight+= weight;
            }
        }
        return mstWeight;
    }
}


class Edge implements Comparable<Edge>{
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
