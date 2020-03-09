
public class CompleteMazeStack {
	String[][][] map;
	Stack<String> path = new Stack<String>();

	public CompleteMazeStack(String[][][] map) {
		this.map = map;
		path.push(KirbyPosition());
		path.print();
	}

	public String KirbyPosition() {
		for (int k = 0; k < map[0][0].length; k++) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if(map[i][j][k].equals("K")) {
						return "K " + i + " " + j;
					}
				}
			}
		} System.out.println("Kirby doesn't exist");
		return null;
	}
}
