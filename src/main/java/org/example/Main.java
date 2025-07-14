package org.example;

import org.example.producer_consumer.ProduceConsumerRunner;
import org.example.sorting.SimpleNumberSort;
import org.example.threading.ThreadingMain;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ThreadingMain threadingMain = new ThreadingMain();
        threadingMain.execute();
//           Runner pcr = new ProduceConsumerRunner();
//           pcr.run();
    }
}