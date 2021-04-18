package com.kkh.algo.exam.algorithm;

import java.util.Arrays;

public class PrimeExam {
    /*
    소수 문제(0과1은 소수가 아님)
    1) 소수 판별
    2) a,b 사이의 모든 소수
    3) n번째 소수

    소수 판별 -> 제곱근으로 판별
    범위내 소수 -> 에라토스테네스의 체
     */
    public static void main(String args[]) {
        // 제곱근으로 소수 판별 -> 시간복잡도 O(sqrt(n))
        //System.out.println(isPrime(71));

        // 에라토스테네스의 체. 배수들을 지워가는 방식 -> 시간 복잡도 O(Nlog(logN))
        // 특정 범위의 모든 소수를 찾을 때
//        System.out.println(isPrime2(20, 71));
//        System.out.println(getPrime(10));

        //System.out.println(_isPrime(33));
        System.out.println(getPrime_(33));      //n까지의 모든 소수

    }


    private static int getPrime(int n) {
        int count = 0;
        int number = 1;
        while (count <= n) {
            if (isPrime(number)) {
                System.out.println("number : " + number);
                count++;
            }
            number++;
        }
        return count;
    }

    private static boolean isPrime2(int a, int n) {
        int arr[] = new int[n + 1];
        arr[0] = 0;
        arr[1] = 0;
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j <= n; j = j + i) {
                arr[j] = 0;
            }
        }

        boolean ret = true;
        int count = 0;
        for (int i = a; i < n + 1; i++) {
            if (arr[i] != 0) {
                System.out.print(i + " ");
                count++;
                ret = false;
            }
        }
        System.out.println();

        return ret;
    }

    private static boolean getPrime_(int n) {

        boolean arr[] = new boolean[n + 1]; // default = false -> 모두 소수가 아니다
        Arrays.fill(arr,true);
        // 0과 1은 소수가 아니다
        // 2는 소수다
        arr[0] = false;
        arr[1] = false;
        arr[2] = true;
        for (int i = 2; i <= n; i++) {
            for (int j = i*2; j <= n; j = j + i) {
                System.out.println("n : " + n + " , j:" + j + " , " + (n % j));
                arr[j] = false;
            }
        }

        for (int i = 0; i <= n; i++) {
            if (arr[i]) {
                // 소수다
                System.out.print(i + " ");
            }
        }
        System.out.println();
        return true;

    }
    private static boolean getPrime2(int n) {

        boolean arr[] = new boolean[n + 1]; // default = false -> 모두 소수가 아니다
        Arrays.fill(arr,true);
        // 0과 1은 소수가 아니다
        // 2는 소수다
        arr[0] = false;
        arr[1] = false;
        arr[2] = true;
        for (int i = 2; i <= n; i++) {
            for (int j = i*2; j <= n; j = j + i) {
                System.out.println("n : " + n + " , j:" + j + " , " + (n % j));
                arr[j] = false;
            }
        }

        for (int i = 0; i <= n; i++) {
            if (arr[i]) {
                // 소수다
                System.out.print(i + " ");
            }
        }
        System.out.println();
        return true;

    }

    private static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {    //짝수가 아닌 것만 체크
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean _isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }


        boolean ret = true;
        for (int i = 3; i < Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                ret = false;
                break;
            }
        }
        return ret;
    }
}
