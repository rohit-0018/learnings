package org.example.producer_consumer;

import org.example.Runner;

public class ProduceConsumerRunner implements Runner {
    public void run() {
        SharedResource sharedResource = new SharedResource();
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        producer.start();
        consumer.start();
    }
}
