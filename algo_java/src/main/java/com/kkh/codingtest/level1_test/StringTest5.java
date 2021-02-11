package com.kkh.codingtest.level1_test;

public class StringTest5 {
    //https://programmers.co.kr/learn/courses/30/lessons/12919
    public static void main(String args[]) {
        StringTest5 st = new StringTest5();
        System.out.println(st.solution(new String[]{"Jane", "Kim"}));
    }


    public String solution(String[] seoul) {
        String answer = "";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].contains("Kim")) {
                answer = "김서방은 " + i + "에 있다";
            }
        }
        return answer;
    }
}
