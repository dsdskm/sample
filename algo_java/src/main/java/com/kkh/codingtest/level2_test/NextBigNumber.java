package com.kkh.codingtest.level2_test;

public class NextBigNumber {
    // https://programmers.co.kr/learn/courses/30/lessons/12911
    public static void main(String args[]) {
        NextBigNumber n = new NextBigNumber();
        System.out.println(n.solution(78)); //83
        System.out.println(n.solution(15)); //23
        System.out.println(n.solution(1000000));
        System.out.println(n.solution(1));

        /*
        조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
        조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
        조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
         */
    }

    public int solution(int n) {
        int answer = n;
        String b = Integer.toBinaryString(n);
        int num = 0;
        for(char c : b.toCharArray()){
            if(c=='1')num++;
        }

        for(answer=n+1;answer<1000000;answer++){
            b = Integer.toBinaryString(answer);
            int a = 0;
            for(char c : b.toCharArray()){
                if(c=='1')a++;
            }
            if(num==a)return answer;

        }
        return answer;
    }
}
