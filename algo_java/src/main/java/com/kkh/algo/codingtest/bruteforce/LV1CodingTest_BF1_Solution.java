package com.kkh.algo.codingtest.bruteforce;

import java.util.ArrayList;

public class LV1CodingTest_BF1_Solution {
    /*
    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
    1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
    가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     */
    public static void main(String[] args) {

        LV1CodingTest_BF1_Solution l = new LV1CodingTest_BF1_Solution();
//        System.out.println(l.solution(new int[]{1, 2, 3, 4, 5}));
        System.out.println(l.solution(new int[]{1, 3, 2, 4, 2}));
        System.out.println(l.solution(new int[]{1, 2, 3, 4, 5, 4}));
    }


    public int[] solution(int[] answers) {
        /*
        주어진 정답을 모두 순회하면서 답을 비교한다
        제일 많이 맞춘 사람 1명만 리턴
        여려명일 경우 오름으로 리
         */
        int[][] a = new int[][]{
                new int[]{1, 2, 3, 4, 5},
                new int[]{2, 1, 2, 3, 2, 4, 2, 5},
                new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] correct = new int[a.length];
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            for (int j = 0; j < a.length; j++) {
                int k = i % a[j].length;
                if (answer == a[j][k]) {
                    correct[j]++;
                }
            }
        }
        int max = 0;
        for (int v : correct) {
            if (max <= v) {
                max = v;
            }
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < correct.length; i++) {

            if (max == correct[i]) {
                answerList.add(i + 1);
            }
        }
        int[] ret = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            ret[i] = answerList.get(i);
        }

        return ret;
    }
}
