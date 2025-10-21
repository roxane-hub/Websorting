package com.example.sorting.controller;

import com.example.sorting.service.SortService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/sort")
public class SortController {

    private final SortService sortService;

    public SortController(SortService sortService) {
        this.sortService = sortService;
    }

    // Example: GET /api/sort/quick?values=5,3,8,1
    @GetMapping("/{algorithm}")
    public ResponseEntity<Map<String, Object>> sort(
            @PathVariable String algorithm,
            @RequestParam String values) {

        String[] parts = values.split(",");
        int[] arr = Arrays.stream(parts)
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .toArray();

        SortService.SortResult result = sortService.sort(arr, algorithm);

        Map<String, Object> response = new HashMap<>();
        response.put("algorithm", result.algorithm);
        response.put("sorted", result.sorted);
        response.put("durationNs", result.durationNs);
        response.put("comparisons", result.comparisons);

        return ResponseEntity.ok(response);
    }
}
