package org.example.sorting;

import java.util.Arrays;
import java.util.List;

public interface Sort {
    public List<Object> arr;

    public void sort() {
        Arrays.sort(arr);
    }
}
