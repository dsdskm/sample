package com.kkh.condigtest.level1_test;

import java.util.Arrays;

public class IntegerTest3 {
    //https://programmers.co.kr/learn/courses/30/lessons/12933
    public static void main(String args[]) {
        IntegerTest3 it = new IntegerTest3();
        System.out.println(it.solution(118372));
    }

    public long solution(long n) {
        long answer = 0;

        int div = 10;

        String str = String.valueOf(n);
        int arr[] = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            arr[i] = num;
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        answer = Long.parseLong(sb.toString());
        return answer;

    }
}
