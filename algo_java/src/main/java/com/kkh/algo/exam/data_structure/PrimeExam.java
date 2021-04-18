package com.kkh.algo.exam.data_structure;

import static java.lang.StrictMath.sqrt;

public class PrimeExam {
    public static void main(String args[]){
        System.out.println(isPrime(5));
        System.out.println(isPrime(12));
    }
    static int isPrime(int n) {
        if( n <= 1 )
            return 0; //1은 소수가 아님.

        // 짝수는 소수에서 제외
        // 단, 2는 유일하게 짝수 중에서 소수
        if( n%2 == 0)
            return n==2 ? 1 : 0;

        // n이 홀수인 경우 sqrt(n)까지 나눠서 나눠떨어지는지 여부 체크
        for(int i=3; i<=sqrt(n); i += 2) {
            // 나눠 떨어진다면 약수에 해당하므로 소수가 아님.
            if( n % i == 0)
                return 0;
        }
        // 위에서 걸러지지 않은 나머지 경우는 소수에 해당됨
        return 1;
    }
}
