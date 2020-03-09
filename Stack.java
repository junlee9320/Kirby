import java.util.ArrayList;

public class Stack<T> {
	private ArrayList<T> data;
	private int size;

	public Stack() {
		data = new ArrayList<T>();
	}

	public void push(T t) {
		data.add(t);
		size++;
	}

	public T pop() {
		size--;
		return data.remove(size);
	}

	public T peek(T t) {
		return data.get(data.size() - 1);
	}

	public boolean isEmpty() {
		return data.size() == 0;
	}

	public int size() {
		return size;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
	public void print() {
		for(int i=0;i<data.size();i++) {
			System.out.println(data.get(i));
		}
	}
}