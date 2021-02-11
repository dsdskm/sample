package com.kkh.codingtest.level1_test;

public class StringTest9 {
    //https://programmers.co.kr/learn/courses/30/lessons/12930
    public static void main(String args[]) {
        StringTest9 st = new StringTest9();
        System.out.println(st.solution("try hello world"));
        System.out.println(st.solution("AaAaA"));
        System.out.println(st.solution("AaAaA AaAaA"));
        System.out.println(st.solution("AaAaA aAaAaA"));
    }

    public String solution(String s) {
        String answer = "";
        int index = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                index = 1;
                sb.append(c);
                continue;
            } else {
                int ascii = (int) c;
                if (index % 2 == 1) {
                    //홀수
                    if (97 <= ascii && ascii <= 122) {
                        // 소문자
                        c = (char) (ascii - 32);
                    }
                } else {
                    //짝수
                    if (65 <= ascii && ascii <= 90) {
                        c = (char) (ascii + 32);
                    }
                }
                index++;
            }
            sb.append(c);
        }
        answer = sb.toString();
        return answer;
    }
}
