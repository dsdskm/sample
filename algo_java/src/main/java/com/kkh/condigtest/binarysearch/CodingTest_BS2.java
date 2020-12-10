package com.kkh.condigtest.binarysearch;

import java.util.Arrays;

public class CodingTest_BS2 {

    public static void main(String args[]) {
        new CodingTest_BS2();
    }

    public CodingTest_BS2() {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {

            long mid = (left + right) / 2;
            long count = 0;

            for (int time : times) {
                count += (long) mid / time;
            }

            if (count >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
