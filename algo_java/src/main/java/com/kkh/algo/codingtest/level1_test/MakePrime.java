package com.kkh.algo.codingtest.level1_test;

public class MakePrime {
    // https://programmers.co.kr/learn/courses/30/lessons/12977
    public static void main(String ags[]) {
        MakePrime m = new MakePrime();
        System.out.println(m.solution(new int[]{1, 2, 3}));
        System.out.println(m.solution(new int[]{1, 2, 3, 4}));
        System.out.println(m.solution(new int[]{1, 2, 7, 6, 4}));
        /*
        주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
        숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

        제한사항
        nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
        nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.

         */
    }

    int answer = 0;
    int arr[];

    public int solution(int[] nums) {
        /*
        3개를 뽑는 조합(순서 상관이 없는)으로 비교를 해본다
         */
        answer = 0;
        arr = new int[3];
        dfs(nums, nums.length, 0, 0, 0);
        return answer;
    }

    private void dfs(int[] nums, int len, int cnt, int sum, int start) {
        if (cnt == 3) {

            if (isPrime(sum)) {
                answer++;
            }
            return;
        }

        for (int i = start; i < len; i++) {
            arr[cnt] = nums[i];
            dfs(nums, len, cnt + 1, sum + nums[i], i + 1);
        }
    }

    private static boolean isPrime(long num) {
        if (num == 0 || num == 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}
