package com.kkh.algo;

import java.util.*;

public class Permutation {
    public static void main(String args[]) {
        Permutation p = new Permutation();
        p.test();

    }

    public void test() {
        boolean visit[] = new boolean[5];
        int arr[] = new int[]{1, 2, 3, 4, 5};
        Arrays.fill(visit,false);
        per2(arr, new int[]{0, 0, 0}, visit, 0, 5, 3);
        Arrays.fill(visit,false);
        per1(arr, 0, 5, 3);
        Arrays.fill(visit,false);

    }

    static void per1(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            per1(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) { //두 배열의 값을 바꾸는 Swap 함수
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void per2(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r); //순열 출력을 위한 print 함수
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                per2(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    private static void printSet(Set<Integer> output, int r) {
        Iterator iter = output.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }

    private static void print(int[] output, int r) {
        for (int i = 0; i < r; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }
}
