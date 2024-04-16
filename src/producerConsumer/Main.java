package producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
//private static final int buffer_Size=5;
//private static final Queue<Integer> q=new LinkedList()<>();
	public static void main(String[] args) {
		int capacity = 5;
		Queue<Integer> q = new LinkedList<>();
		Producer p = new Producer(q, capacity);
		Consumer C = new Consumer(q, capacity);
		p.start();
		C.start();
	}

}
