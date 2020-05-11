import java.util.*;

public class Graph {
    private int V;
    private LinkedList<LinkedList<Integer>> adj;
    public int distance[]; 

    Graph(int v) {
        V = v;
        adj = new LinkedList<LinkedList<Integer>>();
        distance = new int[v];
        for(int i=0; i<v; i++) {
        	distance[i] = 0;
        }
        for (int i = 0; i < v; ++i)
            adj.add(new LinkedList<Integer>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void BFS(int s) {
    	
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = (int) queue.poll();

            	for(Integer n : adj.get(s)) {
            		if (!visited[n]) {
            			visited[n] = true;
            			queue.add(n);
            			distance[n] = distance[s] + 1;
                	}
            	}
            }
       }
    }

