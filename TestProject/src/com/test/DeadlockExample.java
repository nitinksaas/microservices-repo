package com.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {

    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		Runnable taskRun = () -> System.out.println();;
		Callable<Integer> task = () -> 10;

		 ex.submit(taskRun);
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(0);
	//	scheduler.schedule(null, 0, null)s


				Thread t1 = new Thread(() -> {
					try {
						if (lock1.tryLock(1, TimeUnit.SECONDS)) {
							System.out.println("Thread 1 locked lock1");

							try {

								Thread.sleep(100);

							} catch (Exception e) {
							}
							// lock1.notify();
							lock1.unlock();
							if (lock2.tryLock(2, TimeUnit.SECONDS)) {
								System.out.println("Thread 1 locked lock2");
							}
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});

		Thread t2 = new Thread(() -> {
			if (lock2.tryLock()) {
				System.out.println("Thread 2 locked lock2");

				try {

					Thread.sleep(100);
				} catch (Exception e) {
				}
				// lock2.notify();
				lock2.unlock();
				if (lock1.tryLock()) {
					System.out.println("Thread 2 locked lock1");
				}
			}
		});

		t1.start();
		t2.start();
	}
}