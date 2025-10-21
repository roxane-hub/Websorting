package com.example.sorting.service;


import com.example.websorting.algorithm.SortingAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SortService {

    private final Map<String, SortingAlgorithm> algorithms;

    public SortService(Map<String, SortingAlgorithm> algorithms) {
        this.algorithms = algorithms;
    }

    public SortResult sort(int[] data, String algorithmKey) {
        SortingAlgorithm algo = algorithms.get(algorithmKey);
        if (algo == null) throw new IllegalArgumentException("Unknown algorithm: " + algorithmKey);

        int[] copy = data.clone();
        long start = System.nanoTime();
        long comparisons = algo.sort(copy);
        long durationNs = System.nanoTime() - start;

        return new SortResult(algo.name(), copy, durationNs, comparisons);
    }

    public static class SortResult {
        public final String algorithm;
        public final int[] sorted;
        public final long durationNs;
        public final long comparisons;

        public SortResult(String algorithm, int[] sorted, long durationNs, long comparisons) {
            this.algorithm = algorithm;
            this.sorted = sorted;
            this.durationNs = durationNs;
            this.comparisons = comparisons;
        }
    }
}
