package com.kkh.codingtest.dynamic;

public class CodingTest_Dynamic2 {
    public static void main(String args[]) {
        new CodingTest_Dynamic2();
    }

    public CodingTest_Dynamic2() {
        System.out.println(solution(80));
    }

    public long solution(int N) {
        long answer = 0;
        long prv1 = 1;
        long prv2 = 1;
        long current = 0;
        for (int i = 2; i < N; i++) {
            current = prv1 + prv2;
            answer = current * 4 + (prv1 * 2);
            prv2 = prv1;
            prv1 = current;
            System.out.println("["+i+"]current = " + current + " , prv1 = " + prv1 + " , prv2 = " + prv2 + " , sum = " + answer);
        }
        return answer;
    }

}
