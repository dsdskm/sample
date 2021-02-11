package com.kkh.codingtest.level1_test;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayTest {

    //https://programmers.co.kr/learn/courses/30/lessons/12910

    public static void main(String args[]) {
        ArrayTest at = new ArrayTest();
        int res[] = at.solution(new int[]{5, 9, 7, 10}, 5);
        res = at.solution(new int[]{2, 36, 1, 3}, 1);
        res = at.solution(new int[]{3, 2, 6}, 10);
    }

    public int[] solution(int[] arr, int divisor) {
        int answer[] = new int[1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }

        if (list.size() == 0) {
            answer[0] = -1;
//            System.out.println(answer[0]);
        } else {
            answer = new int[list.size()];
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
//                System.out.println(list.get(i));
            }
        }

        return answer;
    }

}
