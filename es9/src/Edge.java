
public class Edge {

	private Node src;
	private Node dest;
	private int cost;
	
	Edge(Node src, Node dest, int cost){
		this.src = src;
		this.dest = dest;
		this.cost = cost;
	}
	
	public Node getSrc() {
		return src;
	}
	
	public Node getDest() {
		return dest;
	}
	
	public int getCost() {
		return cost;
	}
	
	
	
}
