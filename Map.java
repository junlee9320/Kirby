
public class Map {
	private String[][][] textbased;
	private Stack<String> stackmap;
	private Queue<String> queuemap;
	private int[] rcr;
	MazeGenerator generator;
	
	public Map() {
		generator = new MazeGenerator("map1");
		textbased = generator.getMap();
		stackmap = generator.getStack();
		queuemap = generator.getQueue();
		rcr = generator.getRowColRoom();
	}
	
	public Stack<String> getStack(){
		return stackmap;
	}
	
	public Queue<String> getQueue(){
		return queuemap;
	}
	
	public String[][][] getTextBased(){
		return textbased;
	}
	
	public int[] rcr() {
		return rcr;
	}
	
	public void printmap(int c) {
		if(c==0) {
			stackmap.print(); //stack
		}else if(c==1) {
			queuemap.print(); //queue
		}else if(c==2){
			for (int k = 0; k < textbased[0][0].length; k++) { //3d array
				for (int i = 0; i < textbased.length; i++) {
					for (int j = 0; j < textbased[0].length; j++) {
						System.out.print(textbased[i][j][k]);
					}
					System.out.println();
				}
				for(int d=0; d<textbased[0].length;d++) {
					System.out.print("-");
				}
				System.out.println();
			}
		}else {
			System.out.println("input valid condition");
		}
	}
}
