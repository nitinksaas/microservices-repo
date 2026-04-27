package com.test;

class Logger {
    public synchronized void log(String msg) {
        System.out.println(msg);
    }
}

class Resource {

    private final Logger logger;

    public Resource(Logger logger) {
        this.logger = logger;
    }

    public synchronized void useResource() {
        System.out.println(Thread.currentThread().getName() + " using resource");

        // simulate work
         try { Thread.sleep(100); } catch (InterruptedException e) {}

        logger.log(Thread.currentThread().getName() + " logging from resource");
    }
}

public class DeadlockWithLogger {

    public static void main(String[] args) {

        Logger logger = new Logger();
        Resource resource = new Resource(logger);

        Thread t1 = new Thread(() -> {
            synchronized (logger) {
                System.out.println("Thread 1 locked logger");

                resource.useResource(); // 🔥 nested call
            }
        });

        Thread t2 = new Thread(() -> {
            resource.useResource();
        });

        t1.start();
        t2.start();
    }
}