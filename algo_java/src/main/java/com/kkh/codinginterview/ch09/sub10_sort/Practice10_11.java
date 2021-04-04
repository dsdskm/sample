package com.kkh.codinginterview.ch09.sub10_sort;

import java.util.Arrays;
import java.util.Collections;

public class Practice10_11 {
    public static void main(String args[]) {
        new Practice10_11();
    }

    public Practice10_11() {
        solution();
    }

    public void solution() {
        Integer arr[] = new Integer[]{5, 3, 1, 2, 3};

        Arrays.sort(arr, Collections.reverseOrder());
        int arrIndex = 1;
        int index = 0;
        int res[] = new int[arr.length];
        res[index] = arr[0];
        boolean leftToRight = true;
        while (true) {
            if (leftToRight) {
                index = index + 2;
                if (index >= arr.length) {
                    index--;
                    leftToRight = false;
                } else {
                    res[index] = arr[arrIndex++];
                }
            } else {
                index = index - 2;
                if (index < 0 || arrIndex == arr.length) {
                    break;
                } else {
                    res[index] = arr[arrIndex++];
                }
            }


        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

}
