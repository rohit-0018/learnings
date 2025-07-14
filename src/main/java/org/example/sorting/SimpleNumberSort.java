package org.example.sorting;

import org.example.PatternInteractor;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class SimpleNumberSort implements PatternInteractor {
    private final int[] arr = {5,4,3,2,4,5,1,2,3,4};
    private void sort() {
        Arrays.sort(arr);
    }

    @Override
    public void interact() {
        sort();
        System.out.println(Arrays.toString(arr));
    }

}