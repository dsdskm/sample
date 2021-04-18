package com.kkh.algo.codingtest.level1_test;

public class Sqrt {
    /*
    임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
    n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고,
    n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

    제한 사항
    n은 1이상, 50000000000000 이하인 양의 정수입니다.
     */
    public static void main(String args[]) {
        Sqrt s = new Sqrt();
        System.out.println(s.solution(121));    //144
        System.out.println(s.solution(3));    //-1
        System.out.println(s.solution2(50000000000000l));
        System.out.println(s.solution2(49999988518489l));
        System.out.println(s.solution2(1));
    }


    public long solution(long n) {
        long answer = -1;
        for (int i = 1; i < n / 2; i++) {
            if (i * i == n) {
                answer = (i + 1) * (i + 1);
                break;
            }
        }
        return answer;
    }

    public long solution2(long n) {
        // int와 double을 비교한다

        long num1 = (int) Math.sqrt(n);
        double num2 = Math.sqrt(n);
        double div = num2 - num1;
        System.out.println("num1 : " + num1 + " , num2 : " + num2 + " , div : " + div);
        long answer = 0;
        if (div == 0) {
            answer = (num1 + 1) * (num1 + 1);
        } else {
            answer = -1;
        }

        return answer;
    }
}
