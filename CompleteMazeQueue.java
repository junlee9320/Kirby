import java.util.ArrayList;

public class CompleteMazeQueue {
	String[][][] map;
	Queue<String> path = new Queue<String>();
	Queue<String> dequeue = new Queue<String>();
	ArrayList trace = new ArrayList();
	int room;
	boolean cakefound;

	public CompleteMazeQueue(String[][][] map) {
		room = 0;
		cakefound = false;
		this.map = map;
		path.add(KirbyPosition());
		run();
	}

	public String KirbyPosition() {
		for (int k = 0; k < map[0][0].length; k++) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j][k].equals("K")) {
						return "K " + i + " " + j;
					}
				}
			}
		}
		System.out.println("Kirby doesn't exist");
		return null;
	}

	public String[][][] run() {
		if (cakefound) {
			System.out.println("u wan");
			return map;
		}
		if (path.size() != 0) {
			dequeue.add(path.remove());
			String n = checkNSEW(parseIntRow(dequeue.peek()) - 1, parseIntCol(dequeue.peek()), room);
			String s = checkNSEW(parseIntRow(dequeue.peek()) + 1, parseIntCol(dequeue.peek()), room);
			String e = checkNSEW(parseIntRow(dequeue.peek()), parseIntCol(dequeue.peek()) + 1, room);
			String w = checkNSEW(parseIntRow(dequeue.peek()), parseIntCol(dequeue.peek()) - 1, room);
			
			if (n != null) {
				if (n.equals(".")) {
					String coord = n + " " + (parseIntRow(dequeue.peek()) - 1) + " "
							+ (parseIntCol(dequeue.peek()));
					if(checkTraced(coord)) {
						path.add(coord);
						System.out.println("n " + coord);
					}
				} else if (n.equals("C")) {
					cakefound = true;
					System.out.println("oowee");
				}
			}

			if (s != null) {
				if (s.equals(".")) {
					String coord = s + " " + (parseIntRow(dequeue.peek()) + 1) + " "
							+ (parseIntCol(dequeue.peek()));
					if(checkTraced(coord)) {
						path.add(coord);
						System.out.println("s " + coord);
					}
				} else if (s.equals("C")) {
					cakefound = true;
					System.out.println("oowee");
				}
			}

			if (e != null) {
				if (e.equals(".")) {
					String coord = e + " " + (parseIntRow(dequeue.peek())) + " "
							+ (parseIntCol(dequeue.peek()) + 1);
					if(checkTraced(coord)) {
						path.add(coord);
						System.out.println("e " + coord);
					}
				} else if (e.equals("C")) {
					cakefound = true;
					System.out.println("oowee");
				}
			}

			if (w != null) {
				if (w.equals(".")) {
					String coord = w + " " + (parseIntRow(dequeue.peek())) + " "
							+ (parseIntCol(dequeue.peek()) - 1);
					if(checkTraced(coord)) {
						path.add(coord);
						System.out.println("w " + coord);
					}
				} else if (w.equals("C")) {
					cakefound = true;
					System.out.println("oowee");
				}
			}

			trace.add(dequeue.remove());
			return run();

		}

		if (path.size() <= 0) {
			System.out.println("cake be lie");
			return null;
		}
		return null;
	}

	public int parseIntRow(String data) {
		return Integer.parseInt(data.substring(2, 3));
	}

	public int parseIntCol(String data) {
		return Integer.parseInt(data.substring(4));
	}

	public boolean checkTraced(String coords) {
		if (trace.size() != 0) {
			for (int i = 0; i < trace.size(); i++) {
				if (coords.equals(trace.get(i))) {
					return false;
				}
			}
			return true;
		}
		return true;
	}

	public String checkNSEW(int row, int col, int room) {
		if (row >= 0 && row < map.length) {
			if (col >= 0 && col < map[0].length) {
				if (room >= 0 && room < map[0][0].length) {
					return map[row][col][room];
				}
			}
		}
		return null;
	}
}
