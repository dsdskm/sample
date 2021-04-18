package com.kkh.algo.exam.algorithm;

public class CombinationExam {
    public static void main(String args[]) {
        int n = 5;
        int arr[] = {1, 2, 3, 4, 5};
        int output[] = new int[3];
        boolean isVisited[] = new boolean[n];
        combination(arr, isVisited, 0, n, 3);
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited,n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
