package com.kkh.codingtest.level1_test;

public class IntegerTest {
    //https://programmers.co.kr/learn/courses/30/lessons/12931

    public static void main(String args[]) {
        IntegerTest it = new IntegerTest();
        System.out.println(it.solution(123));
        System.out.println(it.solution(987));
    }

    public int solution(int n) {
        int answer = 0;
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String s = String.valueOf(c);
            int number = Integer.parseInt(s);
            answer += number;
        }
        return answer;
    }
}
