package com.kkh.algo.codingtest.level1_test;

public class Hasyad {
    // https://programmers.co.kr/learn/courses/30/lessons/12947
    public static void main(String args[]) {
        Hasyad h = new Hasyad();
        System.out.println(h.solution(10));
        System.out.println(h.solution(12));
        System.out.println(h.solution(11));
        System.out.println(h.solution(13));
        /*
        양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
        예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
        자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
         */
    }

    public boolean solution(int x) {
        /*
        1. 숫자를 문자열로 변환
        2. 문자열 반복 돌면서 합 구한다
        3. 구한 합을 숫자로 전환하여 x로 나눈다
         */

        String str = String.valueOf(x);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Character.getNumericValue(str.charAt(i));
        }
        return x % sum == 0;
    }
}
