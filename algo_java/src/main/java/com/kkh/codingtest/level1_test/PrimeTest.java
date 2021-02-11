package com.kkh.codingtest.level1_test;

public class PrimeTest {
    // https://programmers.co.kr/learn/courses/30/lessons/12921
    public static void main(String args[]) {
        PrimeTest pt = new PrimeTest();
        System.out.println(pt.solution(25));
//        System.out.println(pt.solution(1000));
//        System.out.println(pt.solution(1000000));
    }

    public int solution(int n) {
        int answer = 0;
        int arr[] = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (int j = 2 * i; j <= n; j += i) {
                System.out.println(" i : "+i+" , j : "+j);
                arr[j] = 0;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                answer++;
            }
        }

        return answer;

    }

    public int solution2(int n) {   // O(N^2)
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (checkPrime(i)) {
                answer++;
            }
        }

        return answer;

    }

    private boolean checkPrime(int number) {
        boolean ret = true;
        int n = 2;
        if (n != number && number % 2 == 0) {
            ret = false;
        } else if (number != n) {
            while (true) {
                if (number % n == 0) {
                    ret = false;
                    break;
                }
                n++;
                if (n == number) {
                    break;
                }

            }
        }
        return ret;
    }

}
