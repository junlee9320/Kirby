
public class Runner {

	public static void main(String[] args) {
		Map map = new Map();
		//CompleteMazeStack stackmethod = new CompleteMazeStack(map.getTextBased());
		CompleteMazeQueue queuemethod = new CompleteMazeQueue(map.getTextBased());
		//map.printmap(1);
	}
}