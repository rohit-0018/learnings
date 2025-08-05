package org.example.threading.locks;

import org.example.threading.ThreadingRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain implements ThreadingRunner {
    Stack<String> sharedResource = new Stack<>();
    ReentrantLock lock = new ReentrantLock();

    private void push() {
        for (int i = 0; i < 20; i++) {
            sharedResource.push(i + " - " + Thread.currentThread().getName());
//            sharedResource.add(i + " - " + Thread.currentThread().getName());
        }
    }

    private void pop() {
        for (int i = 0; i < 20; i++) {
            sharedResource.pop();
//            sharedResource.add(i + " - " + Thread.currentThread().getName());
        }
    }

    @Override
    public void mainExecutor() {
//        SharedResource sr = new SharedResource();
        Thread t1 = new Thread(() -> {
            System.out.println("T1 will acquire lock");
            lock.lock();
            push();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            lock.unlock();
        }, "t1");

        Thread t2 = new Thread(() -> {
            System.out.println("T2 will acquire lock");
//            lock.lock();
            if(!sharedResource.isEmpty()) {
                pop();
            } else {
                System.out.println("Nothing in the stack to pop");
            }

//            lock.unlock();
        }, "t2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(sharedResource);
    }
}
