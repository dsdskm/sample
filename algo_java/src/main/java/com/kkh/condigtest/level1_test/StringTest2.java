package com.kkh.condigtest.level1_test;

public class StringTest2 {
    //https://programmers.co.kr/learn/courses/30/lessons/12916
    public static void main(String args[]) {
        StringTest2 st = new StringTest2();
        System.out.println(st.solution("pPoooyY"));
        System.out.println(st.solution("Pyy"));
    }

    boolean solution(String s) {
        boolean answer = false;

        int p_count = 0;
        int y_count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p' || c == 'P') {
                p_count++;
            } else if (c == 'y' || c == 'Y') {
                y_count++;
            }
        }

        if (y_count == 0 && p_count == 0) {
            answer = true;
        } else {
            if (y_count == p_count) {
                answer = true;
            }
        }

        return answer;
    }

}
