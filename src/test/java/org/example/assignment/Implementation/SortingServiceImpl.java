
package org.example.assignment.Implementation;
import com.example.Models.SortResponse;
import com.example.assignment.Algorithms.SortingAlgorithm;
import com.example.sorting.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SortingServiceImpl implements SortingService {

    private final SortingAlgorithm bubbleSort;
    private final SortingAlgorithm selectionSort;
    private final SortingAlgorithm quickSort;
    private final Map<String, SortingAlgorithm> algorithmMap;

    // Constructor Injection with @Autowired (optional in newer Spring versions)
    @Autowired
    public SortingServiceImpl(
            @Qualifier("bubbleSort") SortingAlgorithm bubbleSort,
            @Qualifier("selectionSort") SortingAlgorithm selectionSort,
            @Qualifier("quickSort") SortingAlgorithm quickSort) {
        this.bubbleSort = bubbleSort;
        this.selectionSort = selectionSort;
        this.quickSort = quickSort;

        // Map algorithm names to implementations
        this.algorithmMap = new HashMap<>();
        this.algorithmMap.put("bubble", bubbleSort);
        this.algorithmMap.put("selection", selectionSort);
        this.algorithmMap.put("quick", quickSort);
    }

    @Override
    public SortResponse sortWithBubbleSort(int[] data) {
        return performSort(data, bubbleSort);
    }

    @Override
    public SortResponse sortWithSelectionSort(int[] data) {
        return performSort(data, selectionSort);
    }

    @Override
    public SortResponse sortWithQuickSort(int[] data) {
        return performSort(data, quickSort);
    }

    @Override
    public SortResponse sortWithAlgorithm(String algorithm, int[] data) {
        SortingAlgorithm sortingAlgorithm = algorithmMap.get(algorithm.toLowerCase());
        if (sortingAlgorithm == null) {
            throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        }
        return performSort(data, sortingAlgorithm);
    }

    private SortResponse performSort(int[] data, SortingAlgorithm algorithm) {
        long startTime = System.nanoTime();
        int[] sortedArray = algorithm.sort(data);
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1000000; // Convert to milliseconds

        return new SortResponse(data, sortedArray, algorithm.getAlgorithmName(), executionTime);
    }
}