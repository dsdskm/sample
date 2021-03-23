package com.kkh.codejam.online_2021;

import java.util.Scanner;

public class Problem1 {
    public static void main(String args[]) {
        /*
        글자 하나 입력하는데 1초
        한버튼에서 다른 버튼으로 옮기는데 2초
        최대 6개 인접한 버튼

        QWERTY

        1. Q로 이동(시간X)
        2. Q 입력 1초              -> 1초
        3. W 이동 2초 + 입력 1초      4초
        4. E 이동 2초 + 입력 1초      7초
        5. R 이동 2초 + 입력 1초      10초
        6. T 이동 2초 + 입력 1초      13초
        7. Y 이동 2초 + 입력 1초      16초

        LOM
        1. L 입력 1초                  1초
        2. O 이동 2초 + 입력 1초      4초
        3. M 이동 4초 + 입력 1초      9초
         */
        /*
        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();
        for(int i=0;i<a;i++){
            String str= sc.next();
            System.out.println("str : "+str);
        }
         */

        System.out.println(solution("QWERTY"));
        System.out.println(solution("LOM"));
    }

    private static int solution(String str) {
        /*
        1. 자판 배열을 만든다
        2. 입력받은 문자열로의 이동을 계산한다
        */

        char arr[] = new char[]{
                'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',   // 0 - 9
                'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L',        // 10-18
                'Z', 'X', 'C', 'V', 'B', 'N', 'M'                   // 19-25
        };

        int sum = 1;
        int current_position = -1;
        int prv_position = -1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 0; j < arr.length; j++) {
                if (c == arr[j]) {
                    current_position = j;
                }
            }
            int gap = 0;
            /*
            이도 케이스
            1층 -> 1,2,3층
            2층 -> 1,2,3층
            3층 -> 1,2,3층
             */

            if (0 <= prv_position && prv_position <= 9) {
                if (current_position <= 9) {
                    // 1 to 1
                    gap = (Math.abs(current_position - prv_position)) * 2 + 1;
                } else if (current_position <= 18) {
                    // 1 to 2
                    gap = (Math.abs(current_position - prv_position) - 9) * 2 + 1;
                } else {
                    // 1 to 3
                }
            } else if (10 <= prv_position && prv_position <= 18) {
                if (current_position <= 9) {
                    // 2 to 1
                } else if (current_position <= 18) {
                    // 2 to 2
                } else {
                    // 2 to 3
                }
            } else {
                if (0 <= current_position && current_position <= 9) {
                    // 3 to 1
                } else if (10 <= current_position && current_position <= 18) {
                    // 3 to 2
                } else {
                    // 3 to 3
                }
            }


            sum += gap;
            System.out.println("c : " + c + " , prv_position : " + prv_position + " , current_position : " + current_position + " , gap : " + gap + " , sum : " + sum);
            prv_position = current_position;
        }

        int answer = 0;
        return answer;
    }

}
