package com.example.websorting.algorithm;

import org.springframework.stereotype.Component;

@Component("selection")
public class SelectionSort implements SortingAlgorithm {
    @Override
    public long sort(int[] arr) {
        long comparisons = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return comparisons;
    }

    @Override
    public String name() { return "selection"; }
}
