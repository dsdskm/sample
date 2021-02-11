package com.kkh.codingtest.level1_test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class StringTest {
    //https://programmers.co.kr/learn/courses/30/lessons/12915
    public static void main(String args[]) {
        StringTest st = new StringTest();
        st.solution(new String[]{"sun", "bed", "car"}, 1);
        st.solution(new String[]{"abcd", "abce", "cdx"}, 2);
    }

    class MyData implements Comparable<MyData> {
        int n;
        String mString;

        public MyData(int n, String mString) {
            this.n = n;
            this.mString = mString;
        }


        @Override
        public int compareTo(@NotNull MyData o) {
            char a = mString.charAt(n);
            char b = o.mString.charAt(n);
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                return mString.compareTo(o.mString);
            }
        }
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<MyData> list = new ArrayList<MyData>();
        for (int i = 0; i < strings.length; i++) {
            list.add(new MyData(n, strings[i]));
        }

        Collections.sort(list);
        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).mString;
        }
        return answer;
    }
}
