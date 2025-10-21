

        package com.example.websorting.algorithm;
import com.example.assignment.Algorithms.SortingAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class QuickSort extends SortingAlgorithm {

    @Override
    public int[] sort(int[] array) {
        int[] sortedArray = array.clone();
        quickSort(sortedArray, 0, sortedArray.length - 1);
        return sortedArray;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    @Override
    public String getAlgorithmName() {
        return "Quick Sort";
    }
}