package com.kkh.algo.codinginterview.ch09.sub01_array_string;

import java.util.Arrays;

public class Practice1_2 {
    /*
    1.2 순열 확인_문자열 두 개가 주어졌을 때 이 둘이 서로 순열 관계에 있는지 확인하는 메서드
     */
    public static void main(String ags[]) {
        new Practice1_2();
    }

    public Practice1_2() {
        System.out.println(solution("ABCEA", "CBEAA"));
    }

    private boolean solution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return getSortedText(s).equalsIgnoreCase(getSortedText(t));
    }

    private String getSortedText(String str) {
        char c[] = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }


}
