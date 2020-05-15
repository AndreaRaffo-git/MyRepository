import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static int n;
	
	public static void main(String[] args) throws IOException {
		if(args.length<1) return;
		String filename = args[0];
		HashMap<Integer,Integer> edges = new HashMap<Integer,Integer>();
		edges = readInput(filename);
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		for(int i=0; i<n; i++) {
			Node node = new Node(i);
			nodes.add(i, node);
		}

	}
	
	public static HashMap<Integer,Integer> readInput(String filename) throws IOException {
		FileReader file =new FileReader(filename);
        Scanner scan = new Scanner(file);
        
       n = Integer.parseInt(scan.nextLine());				//numero di vertici
		
		HashMap<Integer, Integer> edges = new HashMap<Integer, Integer>();
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
        	String[] s = line.split(" ");
        	edges.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		}
		file.close();
		scan.close();
		return edges;
	}

}
