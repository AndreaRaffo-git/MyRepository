import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static int[][] input;														
	static int n;
	
	public static void main(String[] args) throws IOException {

		if(args.length <1) return;
		
		String filename = args[0];
		readInput(filename);															//lettura input
		
		ArrayList<Node> nodes = new ArrayList<Node>();									//riempimento array di nodi
		for(int i=0; i<n; i++) {
			Node node = new Node(i);
			nodes.add(node);
		}
		
		
		ArrayList<Edge> edges = new ArrayList<Edge>();									//riempimento array di archi
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
					Edge edge = new Edge(nodes.get(i),nodes.get(j),input[i][j]);
					edges.add(edge);
			}
		}
		
		Collections.sort(edges, new SortByCost());
		for(int i=0; i<edges.size(); i++) {
			System.out.println(edges.get(i).getSrc().getId() + " - " + edges.get(i).getDest().getId() + "  " + edges.get(i).getCost());
		}
		

		
		
	}
	
	public static void kruskalMST(ArrayList<Edge> edges, ArrayList<Node> nodes) {
		
	
	
	}
	
	
	
	
	public static void readInput(String filename) throws IOException {
		FileReader file =new FileReader(filename);
        Scanner scan = new Scanner(file);
     
        n = Integer.parseInt(scan.nextLine());
        input = new int[n][n];
        
        int k=0;
        
        while(scan.hasNextLine()) {
        	
        	String line = scan.nextLine();
        	String[] s = line.split(" ");
        	for(int i=0; i<n; i++) {
        		input[k][i] = Integer.parseInt(s[i]);
        	}
        	k++;
        
        }
	}
}
