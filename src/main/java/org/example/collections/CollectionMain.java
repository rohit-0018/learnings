package org.example.collections;

import org.example.Runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionMain implements Runner {
    private List<String> strList = new ArrayList<>(List.of("Rohit", "Pandey", "Is", "cool", "Amel"));
    private List<Integer> intList = new ArrayList<>(List.of(1,10,22,25, -1));

    void bubbleSort(List<String> list) {
        String temp, right;
//        Collections.sort(list);
        for(int i=0;i<list.size(); i++) {
            for(int j=i; j<list.size(); j++) {
                if(list.get(i).charAt(0)> list.get(j).charAt(0)) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

//    List<String>

    void arrayListOfStringSorting(List<String> stringList) {
        bubbleSort(strList);

    }
    @Override
    public void run() {
         arrayListOfStringSorting(strList);
         print();
    }

    @Override
    public void print() {
        System.out.println(strList);
    }


}
