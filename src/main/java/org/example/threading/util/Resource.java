package org.example.threading.util;

import java.util.ArrayList;
import java.util.List;

public class Resource {
    private final List<Integer>  resource = new ArrayList<>();

    public synchronized void push(int val) {
        resource.add(val);
    }

    public synchronized  void pop() {
        resource.removeLast();
    }

    public synchronized void print() {
        System.out.println("Current Resource value:: "  + " Size " + resource.size() + " resource      "+ resource);
    }
}
