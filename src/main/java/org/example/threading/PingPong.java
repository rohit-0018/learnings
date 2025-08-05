package org.example.threading;

import java.util.Stack;

public class PingPong implements ThreadingRunner{
    private final Stack<Integer> stack = new Stack<>();

    private void ping() {
        while(true) {
            synchronized (stack) {
                if(stack.size()%2 ==0) {
                    System.out.println("Ping");
                    stack.push(1);
                    stack.notify();
                } else {
                    try {
                        stack.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void pong() {
        while (true) {
            synchronized (stack) {
                if(stack.size()%2 !=0) {
                    System.out.println("Pong");
                    stack.push(0);
                    stack.notify();

//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                } else {
                    try {
                        stack.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override
    public void mainExecutor() {
        Thread t1 = new Thread(()-> ping());
        Thread t2 = new Thread(this::pong);
        t1.start();
        t2.start();
    }
}
