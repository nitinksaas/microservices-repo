package com.test;

import java.util.LinkedList;
import java.util.Queue;

class Producer implements Runnable {

	Queue<Integer> queue;
	static int items = 1;
	static int capacity = 1;

	public Producer(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		while (true) { // ✅ infinite loop

			synchronized (this.queue) {

				try {
					// ✅ wait BEFORE producing
					while (this.queue.size() == capacity) {
						this.queue.wait();
					}

					// ✅ produce ONE item
					System.out.println("queue adding:" + items);
					this.queue.add(items++);

					// ✅ notify consumer
					this.queue.notify();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Consumer implements Runnable {

	Queue<Integer> queue;

	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		while (true) { // ✅ infinite loop

			synchronized (this.queue) {

				try {
					// ✅ wait BEFORE consuming
					while (this.queue.isEmpty()) {
						this.queue.wait();
					}

					// ✅ consume ONE item
					Integer item = this.queue.remove();
					System.out.println("queue removing:" + item);

					// ✅ notify producer
					this.queue.notify();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

public class ProducerConsumerTest {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<>();

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);

		Thread t3 = new Thread(producer);
		Thread t4 = new Thread(consumer);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}