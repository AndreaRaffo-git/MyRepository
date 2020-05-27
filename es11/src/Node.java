
public class Node {
	public int id;
	public int cc;
	public Node parent;
	
	Node(int id){
		this.id=id;
		cc=-1;
		parent = null;
	}
	Node(){
		id=-1;
		cc=-1;
		parent = null;
	}
}
