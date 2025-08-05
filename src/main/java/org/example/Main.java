package org.example;

import org.example.collections.CollectionMain;
import org.example.sorting.BubbleSort;
import org.example.sorting.BubbleSortString;
import org.example.sorting.SortRunner;
import org.example.threading.ThreadingMain;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
//        ThreadingMain threadingMain = new ThreadingMain();
//        threadingMain.execute();
//        SortRunner sortRunner = new BubbleSortString();
//        sortRunner.sort();
//        sortRunner.print();
        Runner runner = new CollectionMain();
        runner.run();
//           Runner pcr = new ProduceConsumerRunner();
//           pcr.run();
    }
}