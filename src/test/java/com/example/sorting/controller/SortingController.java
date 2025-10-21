

        package com.example.sorting.controller;

import com.example.Models.DataSet;
import com.example.Models.SortResponse;
import com.example.sorting.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        @RestController
@RequestMapping("/api/sort")
@CrossOrigin(origins = "*")
public class SortingController {

    private final SortingService sortingService;

    @Autowired
    public SortingController(SortingService sortingService) {
        this.sortingService = sortingService;
    }


    @GetMapping("/bubble")
    public ResponseEntity<SortResponse> bubbleSort(@RequestParam int[] data) {
        SortResponse response = sortingService.sortWithBubbleSort(data);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/selection")
    public ResponseEntity<SortResponse> selectionSort(@RequestParam int[] data) {
        SortResponse response = sortingService.sortWithSelectionSort(data);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/quick")
    public ResponseEntity<SortResponse> quickSort(@RequestParam int[] data) {
        SortResponse response = sortingService.sortWithQuickSort(data);
        return ResponseEntity.ok(response);
    }

    // POST endpoint for dynamic algorithm selection
    @PostMapping("/{algorithm}")
    public ResponseEntity<SortResponse> sortWithAlgorithm(
            @PathVariable String algorithm,
            @RequestBody DataSet dataSet) {
        try {
            SortResponse response = sortingService.sortWithAlgorithm(algorithm, dataSet.getNumbers());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(
                    new SortResponse(dataSet.getNumbers(), dataSet.getNumbers(),
                            "Unknown Algorithm", 0)
            );
        }
    }


    @GetMapping("/algorithms")
    public ResponseEntity<String[]> getAvailableAlgorithms() {
        String[] algorithms = {"bubble", "selection", "quick"};
        return ResponseEntity.ok(algorithms);
    }

    // Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Sorting API is running!");
    }
}