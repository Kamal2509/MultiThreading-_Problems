package producerConsumer;

import java.util.Queue;

public class Producer extends Thread {
	int value = 1;
	Queue<Integer> tasklist;
	int capacity;

	public Producer(Queue<Integer> tasklist, int capacity) {
		this.tasklist = tasklist;
		this.capacity = capacity;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (tasklist) {
				while (tasklist.size() == capacity) {
					try {
						tasklist.wait();
						System.out.println("we are full");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Producer produced: " + value);
		          tasklist.add(value++);        
		          tasklist.notify();
		          
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

} 