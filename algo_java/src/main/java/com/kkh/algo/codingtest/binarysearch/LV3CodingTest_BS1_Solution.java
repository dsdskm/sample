package com.kkh.algo.codingtest.binarysearch;

public class LV3CodingTest_BS1_Solution {
    /*
    n명이 입국심사를 위해 줄을 서서 기다리고 있습니다.
    각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
    처음에 모든 심사대는 비어있습니다.
    한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다.
    가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다.
    하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.
    모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.

    입국심사를 기다리는 사람 수 n,
    각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때,
    모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.

    제한사항
    입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
    각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
    심사관은 1명 이상 100,000명 이하입니다.

    가장 첫 두 사람은 바로 심사를 받으러 갑니다.
    7분이 되었을 때, 첫 번째 심사대가 비고 3번째 사람이 심사를 받습니다.
    10분이 되었을 때, 두 번째 심사대가 비고 4번째 사람이 심사를 받습니다.
    14분이 되었을 때, 첫 번째 심사대가 비고 5번째 사람이 심사를 받습니다.
    20분이 되었을 때, 두 번째 심사대가 비지만 6번째 사람이 그곳에서 심사를 받지 않고 1분을 더 기다린 후에 첫 번째 심사대에서 심사를 받으면 28분에 모든 사람의 심사가 끝납니다.
     */
    public static void main(String args[]) {
        LV3CodingTest_BS1_Solution l = new LV3CodingTest_BS1_Solution();
        System.out.println(l.solution(6, new int[]{7, 10}));      // 28
    }

    public long solution(int n, int[] times) {
        /*
        주어진 시간 동안 최대로 처리할 수 있는 사람의 수를 계산해가며 시간을 조합을 찾는다
        https://syundev.tistory.com/170
         */
        long answer = 0;
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        System.out.println("left : "+left+" , right : "+right+" , n : "+n);
        while (left <= right) {

            long mid = (left + right) / 2;
            long count = 0;
            for (int time : times) {
                count += (long) mid / time;
                System.out.println("    mid : "+mid+" , time : "+time+" , count : "+( mid / time));
            }
            System.out.println("mid : "+mid+" , count : "+count+" , n : "+n);
            if (count >= n) {       // 너무 많이 처리한다. 처리 시간이 오래걸리는 desk의 일을 줄여준다
                right = mid - 1;
                answer = mid;
            } else {                // 너무 많이 적게 처리한다. 처리 시간이 적게걸리는 desk의 일을 여준다
                left = mid + 1;
            }
            System.out.println("left : "+left+" , right : "+right);
            System.out.println();
        }

        return answer;
    }
}
