

package com.example.Models;

public class DataSet {
    private int[] numbers;
    private String name;

    public DataSet(int[] numbers, String name) {
        this.setNumbers(numbers);
        this.setName(name);
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}