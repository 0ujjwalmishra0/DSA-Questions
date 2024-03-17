package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvince {
    public static void main(String[] args) {
        int[][] a= new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(a));
    }

    public static int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int count=0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                count++;
                bfs(isConnected,visited);
            }
        }
        return count;

    }
    private static void bfs(int[][] isConnected,boolean[] visited) {

        visited[0]=true;
        Queue<Integer> queue= new LinkedList();
        queue.add(0);
        while(!queue.isEmpty()){
            int u= queue.poll();
            for(int v: isConnected[u]){
                if(!visited[v]){
                    visited[v]=true;
                    queue.add(v);
                }
            }
        }
    }
}
