import java.util.Comparator;

public class SortByX	implements Comparator<Point> {

        public int compare(final Point a, final Point b) {
            if (a.getX() < b.getX()) {
                return -1;
            }
            else if (a.getX() > b.getX()) {
                return 1;
            }
            else if (a.getY() < b.getY()) {
                     return -1;
            }
            else if (a.getY() > b.getY()) {
                     return 1;
            }else {
                	 return 0;
            }
        }
    }