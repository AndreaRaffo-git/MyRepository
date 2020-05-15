import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	private ArrayList<ArrayList<Integer>> adj;
	
	Graph(HashMap<Integer,Integer> edges, int n){
		adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<n; i++) {
		adj.add(i, new ArrayList<Integer>());
		}
		
	
		for (HashMap.Entry<Integer, Integer> entry : edges.entrySet()) {
			int src = entry.getKey();
			int dest = entry.getValue();
			
			adj.get(src).add(dest);
			adj.get(dest).add(src);
		}
		
	}
	
	public void CCvisit(Graph g, Node v, int k){
		v.cc = k;
		
		for(Integer l : g.adj.get(v.id)) {
			
		}
	}
	
	
	
}
