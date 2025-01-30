package graphs;


import java.util.ArrayList;
import java.util.Stack;

public class AlienDictonary {
    public static void main(String[] args) {
        String[] dict= new String[]{"baa","abcd","abca","cab","cad"};
        System.out.println(findOrder(dict,5,4));
    }

    public static String findOrder(String[] dict, int N, int K) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            // Compare dict[i] & dict[i+1]
            int index = 0;
            while (index < dict[i].length() && index < dict[i + 1].length()) {
                if (dict[i].charAt(index) != dict[i + 1].charAt(index)) {
                    // Add edge from dict[i] char to dict[i+1] char
                    adj.get(dict[i].charAt(index) - 'a').add(dict[i + 1].charAt(index) - 'a');
                    break;
                }
                index++;
            }
        }
        return topoSort(adj, K); // Use K instead of N for the number of vertices
    }

    private static String topoSort(ArrayList<ArrayList<Integer>> adj, int K) {
        boolean[] visited = new boolean[K];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                DFS(adj, visited, i, stack);
            }
        }
        while (!stack.isEmpty()) {
            // Convert back to char before appending
            sb.append((char) ('a' + stack.pop()));
        }
        return sb.toString(); // Reverse to get the correct order
    }

    private static void DFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int index, Stack<Integer> stack) {
        visited[index] = true;
        for (int node : adj.get(index)) {
            if (!visited[node]) {
                DFS(adj, visited, node, stack);
            }
        }
        stack.push(index);
    }


}
