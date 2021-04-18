package com.kkh.algo.codingtest.level1_test;

public class Numeral {
    // https://programmers.co.kr/learn/courses/30/lessons/68935
    public static void main(String a[]) {
        Numeral n = new Numeral();
        System.out.println(n.solution(1));  //7
        System.out.println(n.solution(45));  //7
        System.out.println(n.solution(125));  //229

        /*
        n을 3진법 상에서 앞뒤로 뒤집은후 다시 10진법으로 표현
         */

    }

    public int solution(int n) {
        if(n==1){
            return 1;
        }
        /*
        1. 3진법 뒤로 뒤짚는다
        2. 10진법으로 변경한다
         */
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n1 = n % 3;
            sb.append(n1);
            n = n / 3;
            if (n < 3) {
                sb.append(n);
                break;
            }
        }

        String str = sb.toString();
        int pow = 0;
        int answer = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int v = Character.getNumericValue(str.charAt(i));
            v = (int) (v * Math.pow(3, pow++));
            answer += v;
        }
        return answer;
    }


}
