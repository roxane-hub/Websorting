

        package com.example.websorting.algorithm;
import com.example.assignment.Algorithms.SortingAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class SelectionSort extends SortingAlgorithm {

    @Override
    public int[] sort(int[] array) {
        int[] sortedArray = array.clone();
        int n = sortedArray.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (sortedArray[j] < sortedArray[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = sortedArray[minIndex];
            sortedArray[minIndex] = sortedArray[i];
            sortedArray[i] = temp;
        }
        return sortedArray;
    }

    @Override
    public String getAlgorithmName() {
        return "Selection Sort";
    }
}