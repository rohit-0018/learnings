package org.example.producer_consumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SharedResource {
    private final List<Integer> messageQueue= new ArrayList<>();

    public synchronized void enqueue(int value) {
        messageQueue.add(value);
    }

    public synchronized void dequeue() {
        messageQueue.removeLast();
    }

    public void printQueue() {
        System.out.println(messageQueue);
    }

    public int size() {
        return messageQueue.size();
    }
}
