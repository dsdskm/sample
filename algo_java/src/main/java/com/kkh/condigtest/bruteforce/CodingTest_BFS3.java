package com.kkh.condigtest.bruteforce;

import java.util.*;

public class CodingTest_BFS3 {


    public static void main(String args[]) {
        new CodingTest_BFS3();
    }

    public CodingTest_BFS3() {
        System.out.println(solution(new int[][]{{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}}));
    }

    public int solution(int[][] baseball) {
        int[] tmp = new int[3];

        // 가능한 모든 경우의 수를 stack에 넣는다.
        Stack<String> stack = new Stack<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i != j && j != k && i != k) {
                        stack.add(String.valueOf(i * 100 + j * 10 + k));
                    }
                }
            }
        }

        // 맞는 경우의 수를 넣어줄 answerList 선언
        Stack<String> answerList = new Stack<>();

        // 조건의 개수는 baseball.length
        // 조건이 하나라도 안맞는 경우 flag를 통해서 걸러낸다.
        while (!stack.isEmpty()) {
            String out = stack.pop();

            boolean flag = false;
            for (int i = 0; i < baseball.length; i++) {
                int strike = strike(out, String.valueOf(baseball[i][0]));
                int ball = ball(out, String.valueOf(baseball[i][0])) - strike;

                if (strike != baseball[i][1] || ball != baseball[i][2]) {
                    flag = true;
                    break;
                }
            }


            if (flag == false) {
                answerList.add(out);
            }
        }

        return answerList.size();
    }

    static int strike(String n1, String n2) {
        int rtn = 0;
        for (int i = 0; i < 3; i++) {
            if (n1.charAt(i) == n2.charAt(i)) {
                rtn++;
            }
        }
        return rtn;
    }

    static int ball(String n1, String n2) {
        int rtn = 0;

        List<Character> tmp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tmp.add(n2.charAt(i));
        }

        for (int i = 0; i < 3; i++) {
            if (tmp.contains(n1.charAt(i))) {
                rtn++;
            }
        }

        return rtn;
    }

}
