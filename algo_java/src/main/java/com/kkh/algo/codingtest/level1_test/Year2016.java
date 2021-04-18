package com.kkh.algo.codingtest.level1_test;

public class Year2016 {
    // https://programmers.co.kr/learn/courses/30/lessons/12901

    public static void main(String args[]) {
        Year2016 y = new Year2016();
        System.out.println(y.solution(1, 1));
        System.out.println(y.solution(2, 1));
        System.out.println(y.solution(3, 1));
        System.out.println(y.solution(4, 1));
        System.out.println(y.solution(5, 24));
        /*
        2016년 a월 b일은 무슨 요일일까요
        2016년은 윤년
        SUN,MON,TUE,WED,THU,FRI,SAT
         */
    }

    public String solution(int a, int b) {
        //  1   2   3   4   5   6   7   8   9   10  11  12
        //  31  29  31  30  31  30  31  31  30  31  30  31
        // 2016년 1월 1일 금요일
        /*
        1. 12인덱스의 배열에 각 일수를 저장한다
        2. a월 b일이 1월1일로부터 며칠째인지 토탈 일수를 구한다
        3. 5월 24일이면 4월일수 + 24로 계산한다
        4. 토탈일수 % 7
            0 -> 금
            1 -> 토
            2 -> 일
            3 -> 월
            4 -> 화
            5 -> 수
            6 -> 목
         */
        int arr[] = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int total = 0;
        if (a == 1) {
            total = b;
        } else {
            for (int i = 0; i < a - 1; i++) {
                total += arr[i];
            }
            total += b;
        }
        int week = total % 7;
        String answer = "";
        switch (week) {
            case 1:
                answer = "FRI";
                break;
            case 2:
                answer = "SAT";
                break;
            case 3:
                answer = "SUN";
                break;
            case 4:
                answer = "MON";
                break;
            case 5:
                answer = "TUE";
                break;
            case 6:
                answer = "WED";
                break;
            case 0:
                answer = "THU";
                break;


        }
        return answer;

    }
}
