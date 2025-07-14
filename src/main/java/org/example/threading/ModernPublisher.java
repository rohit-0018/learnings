package org.example.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModernPublisher implements ThreadingRunner {

    public final List<Integer> queue = new ArrayList<>();
    Random rand = new Random();
    private static final int MAX = 100;

    Runnable task = () -> {
        System.out.println("Started Publishing");

        while (true) {
            synchronized (queue) {
                while (queue.size() >= MAX) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                int val = rand.nextInt(10);
                queue.add(val);
                System.out.println("Queue updated with: " + val);
                queue.notify(); // Wake up consumer
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    };

    Runnable task2 = () -> {
        System.out.println("Started Consuming");

        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                int val = queue.remove(queue.size() - 1);
                System.out.println("Read from queue: " + val);
                queue.notify(); // Wake up producer
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    };

    public void start() {
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
    }

    @Override
    public void maniExecutor() {
        start();
    }
}
