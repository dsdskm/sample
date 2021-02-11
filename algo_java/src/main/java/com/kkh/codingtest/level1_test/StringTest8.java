package com.kkh.codingtest.level1_test;

public class StringTest8 {
    //https://programmers.co.kr/learn/courses/30/lessons/12926
    public static void main(String args[]) {


        StringTest8 st = new StringTest8();
        System.out.println(st.solution("AB", 1));
        System.out.println(st.solution("z", 1));
        System.out.println(st.solution("a B z", 5));
        System.out.println(st.solution("AB", 3));
        System.out.println(st.solution(" ", 3));
        System.out.println(st.solution("aBcDeFgH", 1));
        for (int i = 1; i <= 25; i++) {
            System.out.println("i:" + i + " , " + st.solution(" j J ", i));
        }
    }

    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        // A = 65, a = 97, Z = 90, z = 122, " " = 32
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ascii = (int) c;
            char value = (char) (ascii + n);
            if (ascii == 32) {
                value = ' ';
            } else if (97 <= ascii && ascii <= 122) {
                // 소문자
                if (ascii + n > 122) {
                    int n_asscii = (97 + ascii + n - 122 - 1);
                    if (123 < n_asscii) {
                        value = (char) (97 + n_asscii - 122 - 1);
                    } else {
                        value = (char) n_asscii;
                    }


                }
            } else if (65 <= ascii && ascii <= 90) {
                // 대문자
                if (ascii + n > 90) {
                    int n_asscii = (65 + ascii + n - 90 - 1);
                    if (90 < n_asscii) {
                        value = (char) (65 + n_asscii - 90 - 1);
                    } else {
                        value = (char) n_asscii;
                    }

                }
            }
            sb.append(value);
        }
        answer = sb.toString();
        return answer;
    }
}
