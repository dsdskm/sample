package com.kkh.codingtest.level1_test;

public class StringTest6 {
    //https://programmers.co.kr/learn/courses/30/lessons/12922
    public static void main(String args[]) {
        StringTest6 st = new StringTest6();
        System.out.println(st.solution(3));
        System.out.println(st.solution(4));
        System.out.println(st.solution(10000));
    }

    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sb.append("수");
            } else {
                sb.append("박");
            }
        }
        answer = sb.toString();
        return answer;
    }

}
