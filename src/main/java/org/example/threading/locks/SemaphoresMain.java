package org.example.threading.locks;

import org.example.threading.ThreadingRunner;

import java.util.ArrayList;
import java.util.List;

public class SemaphoresMain implements ThreadingRunner {
    private List<Integer> list = new ArrayList<>();
    public void criticalSection() {
        System.out.println("Critical section is accessed by thread :: " + Thread.currentThread().getName());
        for(int i=0; i<10; i++) {
            list.add(i);
//            counter++;
            System.out.println("Counter updated by thread"+ Thread.currentThread().getName());
        }
    }
    @Override
    public void mainExecutor() {
        System.out.println("Semaphore execution started!");

        Thread t1 = new Thread(()-> {
            System.out.println("Thread t1, execute start");
            criticalSection();
            System.out.println("Thread t1, execute end");
        });

        Thread t2 = new Thread(()-> {
            System.out.println("Thread t1, execute start");
            criticalSection();
            System.out.println("Thread t1, execute end");
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        System.out.println("Semaphore execution done! " + counter);
    }
}
