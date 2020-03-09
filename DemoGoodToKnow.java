import java.util.ArrayDeque;

public class DemoGoodToKnow {
	public static void main(String[] args) {

		// switch case stuff

		int val = 13245678;

		switch (val) { // not having breaks bleeds into a different case

		case 0:
			System.out.println("val 0");
			// break;
		case 1:
			System.out.println("val 1");
			break;
		case 5:
			System.out.println("blep");
			break;

		default: // all other cases
			System.out.println("warren dropped out");
		}

		// using queues in Java

		ArrayDeque<Integer> Que = new ArrayDeque<Integer>();

		// Que behaves like queue implemented with an array
		// first in first out

		Que.push(1);
		Que.push(71);
		Que.push(14);
		System.out.println(Que.peekLast());

		// try catch methods

		try {
			// when something throws exception
			// or you might want to handle exceptions in this way

			int[] x = null;
			//x[0] = 5;
			int x2 =1;
			x2 = x2/0;

		} catch (NullPointerException w) {
			System.out.println("weird nool punter " + w);
		} catch (Exception e) { // Exception covers all cases
			System.out.println("nerd other exceptions" + e);
		}
	}
}
