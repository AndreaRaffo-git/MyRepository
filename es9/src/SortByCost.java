import java.util.Comparator;

public class SortByCost implements Comparator<Edge> {

	public int compare(Edge a, Edge b) {
		return a.getCost() - b.getCost();
	}
}
