package graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopoLogicalSort {
    public static void main(String[] args) {

    }


    private int[] topoSort(ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> stack= new Stack<>();
        boolean[] visited= new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if(!visited[i]){
                DFS(adj,i,visited,stack);
            }
        }

        int ans[] = new int[adj.size()];
        int i=0;
        while(!stack.isEmpty()){
            int element = stack.pop();
            ans[i]= element;
            i++;
        }
        return ans;
    }
    private void DFS(ArrayList<ArrayList<Integer>> adj, int index, boolean[] visited, Stack<Integer> stack){
        visited[index]=true;
        for(int node: adj.get(index)){
            if(!visited[node]){
                visited[node]=true;
                DFS(adj,node,visited,stack);
            }
        }
        stack.add(index);
    }
}
