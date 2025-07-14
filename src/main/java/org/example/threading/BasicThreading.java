package org.example.threading;

public class BasicThreading implements ThreadingRunner{
    private int counter;
    private Thread t1;
    private Thread t2;

    private  void  increment() {
        counter++;
    }

    private void decrement() {
        counter--;
    }

//    private void init() {
//        t1 = new Thread
//    }

    private void runTaskWithThread1(Runnable task) {
        t1 = new Thread(task);
        t1.start();
    }

    private void runTaskWithThread2(Runnable task) {
        t2 = new Thread(task);
        t2.start();
    }

    public void maniExecutor() {
          int []arr= new int[1000];
        System.out.println(counter + " Initial value");
        runTaskWithThread1(()-> {
            System.out.println("Incrementing in thread 1");

//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            try { Thread.sleep(1); } catch (InterruptedException e) {}
            for(int i: arr) {
                increment();
            }
        });
        runTaskWithThread2(()-> {
            System.out.println("Decrementing in thread 2");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            for(int i: arr) {
                increment();
            }
        });
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter + " new counter value");
    }


}
