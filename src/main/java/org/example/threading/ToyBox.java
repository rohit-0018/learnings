package org.example.threading;

import java.util.Stack;

public class ToyBox implements ThreadingRunner{
    private final Stack<Integer> box = new Stack<>();
    private final int MAX_CAPACITY = 1;

    private void publishToy() {
        while(true) {
            synchronized (box) {
                if(box.isEmpty()) {
                    box.push(1);
                    System.out.println("Published toy");
                    box.notify();
                } else {
                    try {
                        box.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void consumeToy() {
        while(true) {
            synchronized (box) {
                if(!box.isEmpty()) {
                    System.out.println("Consumed toy");
                    box.pop();
                    box.notify();
                } else {
                    try {
                        box.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override
    public void maniExecutor() {
//        publishToy();
        Thread t1 = new Thread(this::publishToy);
        Thread t2 = new Thread(this::consumeToy);
        t2.start();
        t1.start();
        
    }
}
