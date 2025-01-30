package graphs;

import java.util.*;

public class ShortestPathDirected {

    private static class Pair {
        int node;
        int weight;
        Pair(int node, int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int[][] edge= new int[m][3];
        for (int i = 0; i < m; i++) {
            edge[i][0]= sc.nextInt();
            edge[i][1]= sc.nextInt();
            edge[i][2]= sc.nextInt();
        }
        ShortestPathDirected shortestPath= new ShortestPathDirected();

        System.out.println(Arrays.toString(shortestPath.shortestPath(n,m,edge)));
    }
    public int[] shortestPath(int N,int M, int[][] edges) {
        //find topo,fill the stack,maintain a disctance array.
        //check if dist is less then update
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for (int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u= edges[i][0];
            int v=edges[i][1];
            int weight= edges[i][2];
            adj.get(u).add(new Pair(v,weight));
        }

        return shortestDistance(0,adj,N);
    }

    public int[] shortestDistance(int source, ArrayList<ArrayList<Pair>> adj, int N) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];

        // Initialize distances to all vertices as infinite and visited as false
        //topological sort
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i]=true;
                DFS(adj,visited,i,stack);
            }
        }
        Arrays.fill(distance,Integer.MAX_VALUE);
        // Set distance to source as 0
        distance[source] = 0;
        // Process vertices in topological order
        while (!stack.isEmpty()) {
            int u = stack.pop();
            // Update distances of all adjacent vertices
            if (distance[u] != Integer.MAX_VALUE) {
                for (Pair pair : adj.get(u)) {
                    if (distance[u] + pair.weight < distance[pair.node]) {
                        distance[pair.node] = distance[u] + pair.weight;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if(distance[i]==Integer.MAX_VALUE){
                distance[i]=-1;
            }
        }

        return distance;
    }
    private void DFS(ArrayList<ArrayList<Pair>> adj,boolean[] visited,int index,Stack<Integer> stack){
        visited[index]= true;
        for(Pair pair: adj.get(index)){
            if(!visited[pair.node]){
                visited[pair.node]=true;
                DFS(adj,visited,pair.node,stack);
            }
        }
        stack.add(index);
    }

    private int[] dijkstraAlgo(ArrayList<ArrayList<ArrayList<Integer>>> adj,int V,int source){
        int[] distance= new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((x,y)-> x.weight- y.weight);
        pq.add(new Pair(source,0));
        distance[source]=0;
        while (!pq.isEmpty()){
            Pair currentNode = pq.poll();
            int currentVertex = currentNode.node;

            //explore neighbours of current vertex
            //if path to destination vertex via current vertex is less then update
            for (ArrayList<Integer> edge : adj.get(currentVertex)) {
                int destination = edge.get(0);
                int weight = edge.get(1);

                if (distance[currentVertex] + weight < distance[destination]) {
                    distance[destination] = distance[currentVertex] + weight;
                    pq.add(new Pair(destination, distance[destination]));
                }
            }
        }
        return distance;
    }

    private int[] dijkstraAlgo2(ArrayList<ArrayList<Pair>> adj,int V,int source){
        int[] distance= new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((x,y)-> x.weight- y.weight);
        pq.add(new Pair(source,0));
        distance[source]=0;
        while (!pq.isEmpty()){
            Pair currentNode = pq.poll();
            int currentVertex = currentNode.node;

            //explore neighbours of current vertex
            //if path to destination vertex via current vertex is less then update
            for (Pair edge : adj.get(currentVertex)) {
                int destination = edge.node;
                int weight = edge.weight;

                if (distance[currentVertex] + weight < distance[destination]) {
                    distance[destination] = distance[currentVertex] + weight;
                    pq.add(new Pair(destination, distance[destination]));
                }
            }
        }
        return distance;
    }
}
