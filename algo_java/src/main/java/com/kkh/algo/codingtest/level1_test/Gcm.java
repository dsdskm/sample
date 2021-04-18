package com.kkh.algo.codingtest.level1_test;

public class Gcm {
    // https://programmers.co.kr/learn/courses/30/lessons/12940
    /*
    두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
    배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
    예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
    두 수는 1이상 1000000이하의 자연수입니다.
     */
    public static void main(String args[]) {
        Gcm g = new Gcm();
        g.solution(3, 12);
        g.solution(24, 16);

    }

    public int[] solution(int n, int m) {
        /*
        1. n=1 or m=1 -> 1, m*n
        2. n=m -> n,m
         */
        int[] answer = new int[2];
        if (n == 1 || m == 1) {
            answer[0] = 1;
            answer[1] = n * m;
        } else if (n == m) {
            answer[0] = n;
            answer[1] = m;
        } else {
            int tmp;
            int a = n;
            int b = m;
            if(n<m){
                tmp = a;
                a = b;
                b = tmp;
            }
            int ret = 0;
            while(b!=0){
                ret = a%b;
                a = b;
                b = ret;
            }
            answer[0] = a;
            answer[1] = n*m/a;
        }
        //System.out.println(answer[0]+" , "+answer[1]);

        return answer;
    }
}
