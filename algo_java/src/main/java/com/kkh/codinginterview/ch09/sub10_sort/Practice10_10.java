package com.kkh.codinginterview.ch09.sub10_sort;

import java.util.Arrays;

public class Practice10_10 {
    public static void main(String args[]) {
        new Practice10_10();
    }

    public Practice10_10() {
        solution();
    }

    public void solution() {
        int arr[] = new int[]{5, 1, 4, 4, 5, 9, 7, 13, 3};
        Arrays.sort(arr);
        System.out.println(getRankOfNum(1, arr));
        System.out.println(getRankOfNum(3, arr));
        System.out.println(getRankOfNum(4, arr));
    }

    public int getRankOfNum(int value, int arr[]) {
        int count = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            count--;
            if (value == arr[i]) {
                break;
            }
        }
        return count;
    }
}
