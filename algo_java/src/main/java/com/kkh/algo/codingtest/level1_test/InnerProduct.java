package com.kkh.algo.codingtest.level1_test;

public class InnerProduct {

    /*
    https://programmers.co.kr/learn/courses/30/lessons/70128
    문제 설명
    길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다.
    a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.
    이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)
     */
    public static void main(String args[]){
        InnerProduct i = new InnerProduct();
        System.out.println(i.solution(new int[]{1,2,3,4},new int[]{-3,-1,0,2}));
        System.out.println(i.solution(new int[]{-1,0,1},new int[]{1,0,-1}));
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0;i<a.length;i++){
            answer += a[i]*b[i];
        }

        return answer;
    }
}
