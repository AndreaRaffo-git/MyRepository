import java.io.IOException;

public class Main {
	
	public static int n;
	
	public static void main(String[] args) throws IOException {
		
		if(args.length<1)
			return;
		String filename = args[0];
		
        
        Graph g = new Graph();

        g.read_Graph(false,filename);

        g.print_Graph();

        ConnectedComponents ccg = new ConnectedComponents();
        int ncc =  ccg.connected_components(g);
        if(ncc>1) 
        	System.out.println("NO");
        else 
        	System.out.println("SI.... e invece NO");
	
			 
	}


}
