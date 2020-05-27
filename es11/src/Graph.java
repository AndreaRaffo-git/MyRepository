import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Graph {

	static final int MAXV      = 100;
    static final int MAXDEGREE = 50;
    public int       edges[][] = new int[MAXV + 1][MAXDEGREE];
    public int       degree[]  = new int[MAXV + 1];
    public int       nvertices;
    public int       nedges;

 

    Graph()

    {
        nvertices = nedges = 0;
        for (int i = 1; i <= MAXV; i++)
           degree[i] = 0;
    }
    
    
    void read_Graph(boolean directed, String filename) throws IOException

    {
    	FileReader file =new FileReader(filename);
        Scanner scan = new Scanner(file);
        nvertices = Integer.parseInt(scan.nextLine());

      
        while(scan.hasNextLine()) {
        	String line = scan.nextLine();
        	String[] s = line.split(" ");
        	
        	insert_edge(Integer.parseInt(s[0]),  Integer.parseInt(s[1]), directed);
        	
        }
        
        scan.close();
        file.close();

        
    }

 

    void insert_edge(int x, int y, boolean directed)

    {

        if (degree[x] > MAXDEGREE)

            System.out.printf(

                    "Warning: insertion (%d, %d) exceeds max degree\n", x, y);

        edges[x][degree[x]] = y;

        degree[x]++;

        if (!directed)

            insert_edge(y, x, true);

        else

            nedges++;

    }
    
    void print_Graph()

    {

        for (int i = 0; i < nvertices; i++)

        {

            System.out.printf("%d: ", i);

            for (int j = degree[i] - 1; j >= 0; j--)

                System.out.printf(" %d", edges[i][j]);

            System.out.printf("\n");

        }

    }

 
}
