import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeGenerator {
	File file;
	Scanner sc;
	int row, col, room;
	String line;

	String[][][] map;
	Stack<String> stack;
	Queue<String> queue;

	String currentcoords;

	public MazeGenerator(String filename) {
		try {
			file = new File(filename);
			sc = new Scanner(file); // scans map file
			row = sc.nextInt();
			col = sc.nextInt();
			room = sc.nextInt();
			sc.hasNextLine();

			map = new String[row][col][room];
			while (sc.hasNextLine()) {
				for (int k = 0; k < room; k++) {
					for (int i = 0; i < row; i++) {
						line = sc.next(); // stores one line of the maze as a string
						for (int j = 0; j < col; j++) {
							map[i][j][k] = line.substring(j, j + 1); // adds maze data to 3d array
						}
					}
				}
			}

			stack = new Stack<String>(); // puts maze coordinates into stack and queue
			queue = new Queue<String>();
			for (int k = 0; k < room; k++) {
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						currentcoords = map[i][j][k] + " " + i + " " + j; // coordinate-based format
						stack.push(currentcoords);
						queue.add(currentcoords);
					}
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String[][][] getMap() { // returns text-based map
		return map;
	}

	public Stack<String> getStack() { // returns coordinate-based map in stack
		return stack;
	}

	public Queue<String> getQueue() { // returns coordinate-based map in queue
		return queue;
	}

	public int[] getRowColRoom() { // returns rows, columns, and rooms in an array
		int[] rcr = { row, col, room };
		return rcr;
	}
}
