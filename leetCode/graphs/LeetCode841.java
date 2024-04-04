package leetCode.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode841 {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Integer> room = new ArrayList<>();
            if(i<3) {
                room.add(i + 1);
            }
            rooms.add(room);
        }
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0]= true;
        while(!queue.isEmpty()){
            Integer x = queue.poll();
            for(int node: rooms.get(x)){
                if(!visited[node]){
                    visited[node]=true;
                    queue.add(node);
                }
            }
        }

        for(boolean e: visited){
            if(!e) return false;
        }
        return true;
    }
}
