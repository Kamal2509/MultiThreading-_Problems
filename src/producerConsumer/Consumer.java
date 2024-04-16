package producerConsumer;

import java.util.Queue;

public class Consumer extends Thread {
	int capacity;
	Queue<Integer> tasklist;

	public Consumer(Queue<Integer> tasklist, int capacity) {
		this.tasklist = tasklist;
		this.capacity = capacity;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (tasklist) {
				while (tasklist.isEmpty()) {
					try {
						tasklist.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				int value = tasklist.poll();
				System.out.println("Consumer Consumed: " + value);

				tasklist.notify();

				
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
