package org.example.sorting;


import java.util.Arrays;

public class BubbleSort implements SortRunner {
    private final int[] arr = {5,4,3,2,4,5,1,11,2,3,4};

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public void sort() {
        for(int i=0; i< arr.length; i++) {
            for(int j=i+1; j< arr.length; j++) {
                if(arr[i]>arr[j]) {
                    swap(j, i);
                }
            }
        }
//        Arrays.sort(arr);
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(arr));
    }

}