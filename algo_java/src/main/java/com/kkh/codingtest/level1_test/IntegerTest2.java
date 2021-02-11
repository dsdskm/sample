package com.kkh.codingtest.level1_test;

import java.util.ArrayList;

public class IntegerTest2 {
    //https://programmers.co.kr/learn/courses/30/lessons/12931

    public static void main(String args[]) {
        IntegerTest2 it = new IntegerTest2();
        System.out.println(it.solution(12345));
    }

    public int[] solution(int n) {
        int answer[] = {};
        ArrayList<Integer> list = new ArrayList<>();
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            list.add(num);
        }
        answer = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            answer[list.size() - i-1] = list.get(i);
        }

        return answer;
    }
}
