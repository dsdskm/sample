package com.kkh.algo.strategy.ch06;

import java.util.HashSet;

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
        System.out.println(solution(6, 10, new int[]{0,1,0,2,1,2,1,3,1,4,2,3,2,4,3,4,3,5,4,5}));
    }

    static boolean areFriends[][];
    static HashSet<Integer> set = new HashSet<>();

    public static int solution(int n, int m, int arr[]) {

        boolean taken[] = new boolean[10];
        areFriends = new boolean[10][10];
        for (int i = 0; i < arr.length; i += 2) {
            areFriends[arr[i]][arr[i + 1]] = areFriends[arr[i + 1]][arr[i]] = true;
        }
        int ret = countParing(taken, n);
        return ret;
    }

    public static int countParing(boolean taken[], int n) {
        int firstFree = -1;
        for (int i = 0; i < n; i++) {
            if (!taken[i]) {
                firstFree = i;
                break;
            }
        }

        if (firstFree == -1) {
            return 1;
        }

        int ret = 0;
        for (int pairWith = firstFree + 1; pairWith < n; ++pairWith) {
            //해당 인덱스가 친구와 짝이 지어지지 않았고, 해당 학생과 친구이면
            if (!taken[pairWith] && areFriends[firstFree][pairWith]) {
                //해당 인덱스는 친구이므로 짝을 지어준다.
                taken[firstFree] = taken[pairWith] = true;
                //경우의 수를 재귀 호출를 통해 반복해서 구한다.
                ret += countParing(taken, n);
                //인덱스가 재귀 호출 과정에서 변하므로 false를 할당한다.(해당 친구의 다음 짝을 계산해야 하므로)
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        //계산 결과(경우의 수) 반환
        return ret;
    }

}
