import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		
		ArrayList<String> lista1 = new ArrayList<String>();
		ArrayList<String> lista2 = new ArrayList<String>();
		int flag = 0;

		String filename1 = args[0];
		String filename2 = args[1];
		FileReader file1 =new FileReader(filename1);
        Scanner scan1 = new Scanner(file1);
        FileReader file2 =new FileReader(filename2);
        Scanner scan2 = new Scanner(file2);
   
        while(scan1.hasNext() && scan2.hasNext()) {
        String word1 = scan1.next();
        String word2 = scan2.next();
        	while(!word1.equals(word2)) {
        		flag = 1;
        		lista1.add(word1);
        		lista2.add(word2);
        		word1 = scan1.next();
        		word2 = scan2.next();
        	}
        	if(flag == 1) {
        		System.out.print("1: ");
        		for(int i=0; i<lista1.size(); i++) {
        			System.out.print(lista1.get(i) + " ");
        		}
        		System.out.println();
        		System.out.print("2: ");
        		for(int i=0; i<lista2.size(); i++) {
        			System.out.print(lista2.get(i) + " ");
        		}
        		System.out.println();
        		System.out.println();
        		lista1.clear();
        		lista2.clear();
        		flag = 0;
        	}
     
        }
	}

}
