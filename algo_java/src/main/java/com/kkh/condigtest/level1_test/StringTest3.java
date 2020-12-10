package com.kkh.condigtest.level1_test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class StringTest3 {
    //https://programmers.co.kr/learn/courses/30/lessons/12917
    public static void main(String args[]) {
        StringTest3 st = new StringTest3();
        st.solution("Zbcdefg");
    }

    class Str implements Comparable<Str> {
        char c;

        public Str(char c) {
            this.c = c;
        }

        @Override
        public int compareTo(Str o) {

            if (c < o.c) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public String solution(String s) {
        String answer = "";
        ArrayList<Str> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            list.add(new Str(c));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i).c;
        }
        return answer;
    }
}
