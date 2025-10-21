
package com.example.sorting.service;
import com.example.Models.SortResponse;
public interface SortingService {
    SortResponse sortWithBubbleSort(int[] data);
    SortResponse sortWithSelectionSort(int[] data);
    SortResponse sortWithQuickSort(int[] data);
    SortResponse sortWithAlgorithm(String algorithm, int[] data);
}