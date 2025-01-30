package graphs;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node){
        if(node==parent.get(node)) return node;
        int ultimateParent= findUParent(parent.get(node));
        parent.set(node,ultimateParent);
        return parent.get(node);
    }
    public void unionBySize(int u,int v){
        int ulp_u= findUParent(u);
        int ulp_v= findUParent(v);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            int totalSize= size.get(ulp_u)+size.get(ulp_v);
            size.set(ulp_v,totalSize); //size will increase of parent
        }
        else {
            parent.set(ulp_v,ulp_u);
            int totalSize= size.get(ulp_u)+size.get(ulp_v);
            size.set(ulp_u,totalSize); //size will increase of parent
        }

    }
    public void unionByRank(int u,int v){
        int ulp_u= findUParent(u);
        int ulp_v= findUParent(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else if (rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }
        else{
            //attach anyone to anyone
            parent.set(ulp_u,ulp_v);
            int rankOfU= rank.get(ulp_u);
            rank.set(ulp_u,rankOfU+1);
        }
    }

    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(7);
        disjointSet.unionBySize(1,2);
        disjointSet.unionBySize(2,3);
        disjointSet.unionBySize(4,5);
        disjointSet.unionBySize(6,7);
        disjointSet.unionBySize(5,6);
        //check if 3 nd 7 belong to same component
        if(disjointSet.findUParent(3)==disjointSet.findUParent(7)){
            System.out.println("same");
        }else{
            System.out.println("Different");
        }

        disjointSet.unionBySize(3,7);

        //check again if 3 nd 7 belong to same component
        if(disjointSet.findUParent(3)==disjointSet.findUParent(7)){
            System.out.println("same");
        }else{
            System.out.println("Different");
        }
    }
}
