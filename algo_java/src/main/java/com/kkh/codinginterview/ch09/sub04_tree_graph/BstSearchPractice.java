package com.kkh.codinginterview.ch09.sub04_tree_graph;

public class BstSearchPractice {
    public static void main(String args[]) {
        new BstSearchPractice();
    }

    public BstSearchPractice() {
        int arr[] = new int[]{1, 3, 4, 6, 7, 8, 10, 13, 14};
        System.out.println(search(arr, 0, arr.length, 13));

    }

    public int search(int arr[], int start, int end, int value) {
        if (start > end) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = arr[midIndex];
        if (midValue == value) {
            return midIndex;
        } else if (value < midValue) {
            return search(arr, start, midIndex, value);
        } else {
            return search(arr, midIndex + 1, end, value);
        }
    }
}
