package org.example.sorting;


import java.util.Arrays;

public class BubbleSortString implements SortRunner {
    private final String[] arr = {"Rohit", "Nidhu", "Pandey", "Pandey", "Babe"};

    private void swap(int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void compareStrings(String s1, String s2) {
        boolean b = s1.charAt(0) > s2.charAt(0);
    }

    @Override
    public void sort() {
        for (int i =0; i< arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i].charAt(0)> arr[j].charAt(0)) {
                    swap(i, j);
                }
            }
        }

    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(arr));
    }

}