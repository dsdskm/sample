package com.kkh.condigtest.level1_test;

public class StringTest7 {
    // https://programmers.co.kr/learn/courses/30/lessons/12925
    public static void main(String args[]) {
        StringTest7 st = new StringTest7();
        System.out.println(st.solution("1234"));
        System.out.println(st.solution("+1234"));
        System.out.println(st.solution("-1234"));
    }

    public int solution(String s) {
        int answer = 0;
        if (s.startsWith("+")) {
            s = s.substring(1);
            answer = Integer.parseInt(s);
        } else if (s.startsWith("-")) {
            s = s.substring(1);
            answer = Integer.parseInt(s);
            answer *= -1;
        } else {
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}
