package com.kkh.algo.exam.algorithm;

public class PowerSetExam {
    public static void main(String args[]){
        int n = 5;
        int arr[] = {1, 2, 3, 4, 5};
        boolean isVisited[] = new boolean[n];
        powerSet(arr, isVisited, n, 0);
    }
    static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
        if(idx == n) {
            print(arr, visited, n);
            return;
        }

        visited[idx] = false;
        powerSet(arr, visited, n, idx + 1);

        visited[idx] = true;
        powerSet(arr, visited, n, idx + 1);
    }

    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
