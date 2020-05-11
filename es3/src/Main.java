import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Point> points = new ArrayList<Point>();
		ArrayList<Point> deletedPoints = new ArrayList<Point>();
		
		String filename = args[0];
		FileReader file =new FileReader(filename);
        Scanner scan = new Scanner(file);
        
        int num = Integer.parseInt(scan.nextLine());
        while(scan.hasNextLine()) {
        	String line = scan.nextLine();
        	String[] s = line.split(" ");
        	Point point = new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
        	points.add(point);
        }
	
        
        for(int k=0; k<num; k++) {
        
        	double minDistance = distance(points.get(0),points.get(1));
        	Point p1 = points.get(0);
        	Point p2 = points.get(1);
        
        	for(int i=0; i<points.size(); i++) {
        		for(int j=0; j< points.size(); j++) {
        			if(i!=j) {
        				double distance = distance(points.get(i),points.get(j));
        				if(distance < minDistance) {
        					minDistance = distance;
        					p1 = points.get(i);
        					p2 = points.get(j);
        				}
        			}
        		}
        	}
        

        	if(p1.getY()>p2.getY()) {
        		points.remove(p1);
        		deletedPoints.add(p1);
        	}else if(p2.getY()>p1.getY()) {
        		points.remove(p2);
        		deletedPoints.add(p2);
        	}else if(p1.getX()>p2.getX()) {
        		points.remove(p1);
        		deletedPoints.add(p1);
        	}else {
        		points.remove(p2);
        		deletedPoints.add(p2);
        	}
       
        }
        
        Collections.sort(deletedPoints, new SortByX());
        for(int i=0; i<deletedPoints.size();i++) {
        System.out.println(deletedPoints.get(i).getX() + " " + deletedPoints.get(i).getY());
        }
        
        file.close();
        scan.close();
	}

	public static double distance(Point a, Point b) {
		double x= Math.pow((b.getX()-a.getX()), 2);
		double y= Math.pow((b.getY()-a.getY()), 2);
		double distance = Math.sqrt(x+y);
		return distance;
	}
	
	
}

