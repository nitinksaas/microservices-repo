package com.test;

public class WaitExample {

	private static final Object lock = new Object();

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			synchronized (lock) {
				System.out.println("T1 acquired lock");
				try {
					System.out.println("T1 is waiting...");
					lock.wait(); // releases lock here
					System.out.println("T1 resumed after notify");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("T1 releasing lock");
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				Thread.sleep(1000); // ensure T1 runs first
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (lock) {
				System.out.println("T2 acquired lock");
				lock.notify(); // wakes up T1
				System.out.println("T2 sent notify");
			}
		});

		t1.start();
		t2.start();
	}
}