

        package com.example.assignment.Algorithms;
import org.springframework.stereotype.Component;

@Component
public class BubbleSort extends SortingAlgorithm {

    @Override
    public int[] sort(int[] array) {
        int n = array.length;
        int[] sortedArray = array.clone();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {

                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }

    @Override
    public String getAlgorithmName() {
        return "Bubble Sort";
    }
}