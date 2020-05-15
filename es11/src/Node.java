public class Node {

	public int id;
	public int cc;
	public Node parent;

	
	Node(int id){
		this.id = id;
		cc = -1;
		parent = null;
	}
}
