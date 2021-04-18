package com.kkh.algo.exam.algorithm;

public class PermutationExam {
    public static void main(String args[]) {
        int n = 5;
        int arr[] = {1, 2, 3, 4, 5};
        int output[] = new int[3];
        boolean isVisited[] = new boolean[n];
        perm(arr, output, isVisited, 0, n, 3);
    }

    private static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }

    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
