import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		int v1 = 0;
		int v2 = 0;
		int v3 = 0;
		
		ArrayList<Orario> listaOrari = new ArrayList<Orario>();
		
		String filename = args[0];
		FileReader file =new FileReader(filename);
        Scanner scan = new Scanner(file);
   
        String line = scan.nextLine();
        String[] s = line.split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        
        while(scan.hasNextLine()) {
        	line = scan.nextLine();
        	s = line.split(" ");
        	Orario orario = new Orario(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]));
        	listaOrari.add(orario);
        }
        
        file.close();
        scan.close();
		
        int[] oreDocenti = new int[n];
        for(int i=0; i<n; i++) {
        	oreDocenti[i] = 0;
        }
        
        for(int i=0; i<listaOrari.size(); i++) {
        	
        	oreDocenti[listaOrari.get(i).getD()-1] += 1;			
        	
    		for(int j=i+1; j<listaOrari.size(); j++) {
    					
    				if(listaOrari.get(i).getD() == listaOrari.get(j).getD()) {															//primo vincolo
    					if(listaOrari.get(i).getA() != listaOrari.get(j).getA()) {
    						if(listaOrari.get(i).getG() == listaOrari.get(j).getG() && listaOrari.get(i).getH() == listaOrari.get(j).getH()) {
    							v1++;
    						}
    					}
    				}
    				
    				if(listaOrari.get(i).getA() == listaOrari.get(j).getA() && listaOrari.get(i).getG() == listaOrari.get(j).getG() 	//secondo vincolo
    						&&	listaOrari.get(i).getH() == listaOrari.get(j).getH()) {
    					if(listaOrari.get(i).getD() != listaOrari.get(j).getD()) {
    						v2++;
    					}
    				}
    			
    		}
        }
		
        
       for(int i=0; i<n; i++) {				//terzo vincolo
    	   if(oreDocenti[i]<k) {
    		   v3++;
    	   }
       }
		
       System.out.println("Violazioni vincolo 1 : " + v1);
       System.out.println("Violazioni vincolo 2 : " + v2);
       System.out.println("Violazioni vincolo 3 : " + v3);
       
      
	}

}
