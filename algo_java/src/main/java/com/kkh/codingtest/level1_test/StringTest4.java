package com.kkh.codingtest.level1_test;

public class StringTest4 {
    //https://programmers.co.kr/learn/courses/30/lessons/12918
    public static void main(String args[]) {
        StringTest4 st = new StringTest4();
        System.out.println(st.solution("a234"));
        System.out.println(st.solution("1234"));
    }

    public boolean solution(String s) {
        boolean answer = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '0' &&
                    c != '1' &&
                    c != '2' &&
                    c != '3' &&
                    c != '4' &&
                    c != '5' &&
                    c != '6' &&
                    c != '7' &&
                    c != '8' &&
                    c != '9') {
                answer = false;
                break;
            }
        }

        if (answer) {
            if (s.length() != 4 && s.length() != 6) {
                answer = false;
            }
        }


        return answer;
    }
}
