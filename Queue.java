import java.util.ArrayList;

public class Queue<T> {
	private ArrayList<T> data;
	private int size;

	public Queue() {
		data = new ArrayList<T>();
	}

	public void add(T t) {
		data.add(t);
		size++;
	}

	public T remove() {
		size--;
		return data.remove(0);
	}

	public T peek() {
		return data.get(0);
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