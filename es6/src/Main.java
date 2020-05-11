import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static HashMap<Integer, Position> targets;
	static ArrayList<Position> path;
	static Position start;
	static char[][] maze;
	static boolean[][] visited;
	
	public static void main(String args[]) throws IOException {
		

		start = new Position();	
		targets = new HashMap<Integer, Position>();
		path = new ArrayList<Position>();
		
        readInput(args[0]);
        

        for (Integer i : targets.keySet()) {
        	if(explore(maze,start,targets.get(i))) {
        		System.out.println(i + " " + (path.size() -2));
        	}else {
        		System.out.println(i + " " + (-1));
        	}
        	clearVisited(maze.length, maze[0].length);
        	path.clear();
        }
        
	}
	
	static boolean explore(char[][] maze, Position p, Position target) {
		if(!isValid(maze,p) || isWall(maze,p) || isVisited(p)) {
			return false;
		}
		
		path.add(p);
		visited[p.x][p.y]= true; 
		
		if(p.x == target.x && p.y == target.y) {
			return true;
		}
		
		
		for(int[] direction : DIRECTIONS) {
			Position position = getNextPosition(p,direction[0],direction[1]);
			if(explore(maze,position,target)) 
				return true;
		}
		
		path.remove(path.size() -1);
		return false;
		
	}
	
	static boolean isValid(char[][] maze, Position p) {
		if(p.x < 0 || p.x >= maze.length || p.y < 0 || p.y >=maze[0].length) 
			return false;
		return true;
	}
	
	static boolean isWall(char[][] maze, Position p) {
		if(maze[p.x][p.y]== '*') return true;
		return false;
	}
	
	static boolean isVisited(Position p) {
		return visited[p.x][p.y];
	}
	
	static void printMaze(char[][] maze, int row, int col) {
		for(int i=0; i<row; i++) {
        	for(int j=0; j<col; j++) {
        		System.out.print(maze[i][j]);
        	}
        	System.out.println();
		}
	
	}
	
	static void clearVisited(int row, int col) {
		for(int i=0; i<row; i++) {
        	for(int j=0; j<col; j++) {
        		visited[i][j] = false;
        	}
        }
	}
	
	static void readInput(String filename) throws IOException {
		FileReader file =new FileReader(filename);
        Scanner scan = new Scanner(file);
        
        int row=1;
        int col = scan.nextLine().length();
       
        while(scan.hasNextLine()) {
        	row++;
        	scan.nextLine();
        }
        
        maze = new char[row][col];
        visited = new boolean[row][col];
        
        file =new FileReader(filename);
        scan = new Scanner(file);
        int i=0;
        while(scan.hasNextLine()) {
        	String line = scan.nextLine();
        	maze[i] = line.toCharArray();
        	i++;
        }
        
        clearVisited(row,col);
        
        for(i=0; i<row; i++) {
        	for(int j=0; j<col; j++) {
        		if(maze[i][j] == '0') {
        			start = new Position(i,j);
        		}else if(Character.isDigit(maze[i][j])){
        			Position target = new Position(i,j);
        			targets.put(Integer.parseInt(String.valueOf(maze[i][j])), target);
        		}
        		}
        }
        
	}
	
	static Position getNextPosition(Position p, int i , int j) {
		return new Position(p.x + i, p.y +j);
	}
	
	
}
