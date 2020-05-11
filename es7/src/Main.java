
public class Main {

	public static void main(String[] args) {
		
		int v = 4;
		Graph g = new Graph(v);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);


        g.BFS(0);
        
        if(g.distance[v-1] != 0) 
        	System.out.println("SI " + g.distance[v-1]);
        else
        	System.out.println("NO " + -1);
		
		

	}

}
