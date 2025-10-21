package com.example.websorting.algorithm;

import org.springframework.stereotype.Component;

@Component("bubble")
public class BubbleSort implements SortingAlgorithm {
    @Override
    public long sort(int[] arr) {
        long comparisons = 0;
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return comparisons;
    }

    @Override
    public String name() { return "bubble"; }
}
