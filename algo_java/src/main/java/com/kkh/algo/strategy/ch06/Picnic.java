package com.kkh.algo.strategy.ch06;

public class Picnic {
    /*
    학생의 수 n
    친구 쌍의 수 m
    m개의 정수 쌍

    2 1
    0 1
    1

    4 6
    0 1 1 2 2 3 3 0 0 2 1 3
    3

    6 10
    0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5
    4
     */
    public static void main(String args[]) {
        System.out.println(solution(4, 6, new int[]{0, 1, 1, 2, 2, 3, 3, 0, 0, 2, 1, 3}));
    }

    public static int solution(int n, int m, int arr[]) {
        /*
        1. 모든 짝의 조합을 검사한다
        2. 모두가 짝을 찾았을 경우를 카운트 한다
         */
        int pairArr[][] = new int[m][];
        int index = 0;
        for (int i = 0; i < arr.length; i += 2) {
            pairArr[index++] = new int[]{arr[i], arr[i + 1]};
            System.out.println(arr[i] + " , " + arr[i + 1]);
        }
        int checkCount = n / 2;

        boolean checkedArr[] = new boolean[pairArr.length];
        for (int i = 0; i < pairArr.length; i++) {
            if (!checkedArr[pairArr[i][0]] && !checkedArr[pairArr[i][1]]) {
                checkedArr[pairArr[i][0]] = checkedArr[pairArr[i][1]] = true;
                checked(i, pairArr, checkedArr, checkCount - 1);
            }

        }
        int ret = 0;
        return ret;
    }

    public static void checked(int index, int pairArr[][], boolean checkedArr[], int checkCount) {
        System.out.println("checkCount index : " + index + " , " + checkCount);
        if (checkCount == 0) {
            System.out.println("checkCount is 0");
            return;
        }
        for (int i = 0; i < pairArr.length; i++) {
            System.out.println(pairArr[i][0] + " , " + pairArr[i][1]);
            if (i != index) {
                if (!checkedArr[pairArr[i][0]] && !checkedArr[pairArr[i][1]]) {
                    checkedArr[pairArr[i][0]] = checkedArr[pairArr[i][1]] = true;
                    checked(i, pairArr, checkedArr, checkCount - 1);
                }
            }
        }
    }

}
