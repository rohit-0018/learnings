package org.example.producer_consumer;

import java.util.Random;

public class Consumer {
    SharedResource sharedResource;
    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void start() {
        System.out.println("Producer started execution");
        Random rand = new Random();
        Thread t1;

        try {
            Runnable task = ()-> {
                while(true) {
                    if(sharedResource.size() ==0) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        sharedResource.dequeue();
                        notifyAll();
                    }

                }

            };
            t1 = new Thread(task);
            t1.start();



        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
