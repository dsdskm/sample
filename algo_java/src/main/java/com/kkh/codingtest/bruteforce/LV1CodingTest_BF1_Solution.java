package com.kkh.codingtest.bruteforce;

public class LV1CodingTest_BF1_Solution {
    /*
    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
    1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
    가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     */
    public static void main(String args[]) {
        LV1CodingTest_BF1_Solution l = new LV1CodingTest_BF1_Solution();
    }

    public int[] solution(int[] answers) {
        int a1[] = new int[]{1,2,3,4,5};
        int a2[] = new int[]{2,1,2,3,2,4,2,5};
        int a3[] = new int[]{3,3,1,1,2,2,4,4,5,5};
        int ret[] = new int[3];

        for(int i=0;i< answers.length;i++){

        }
        return ret;
    }
}
