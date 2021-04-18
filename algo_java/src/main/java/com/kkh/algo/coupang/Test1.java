package com.kkh.algo.coupang;

import java.util.Arrays;

public class Test1 {
    public static void main(String args[]) {
        Test1 t = new Test1();
        System.out.println(t.solution(new int[]{1,2,3,4,11,2,332,5, 3, 9, 13}, 8));
//        System.out.println(t.solution(new int[]{5, 3, 9, 13}, 7));
        /*

        배열 arr과 n이 입력으로 주어진다
        서로 다른 2개의 자연수를 합하여 숫자 n을 만드는 것이 가능하면 true, 불가능하면 false
        조합

         */
    }

    public boolean solution(int[] arr, int n) {
        Arrays.sort(arr);
        int len = arr.length;
        boolean visited[] = new boolean[len];
        boolean answers[] = new boolean[1];
        combination(arr, visited, 0, len, 2,n,answers);
        boolean answer = answers[0];
        return answer;
    }

    void combination(int[] arr, boolean[] visited, int start, int len, int r, int n, boolean[] answers) {
        if (r == 0) {
            int sum = print(arr, visited, len);
            System.out.println("sum : "+sum);
            if (sum == n) {
                answers[0] = true;
                return;
            }
        }

        for (int i = start; i < len; i++) {
            if(!answers[0]) {
                visited[i] = true;
                combination(arr, visited, i + 1, len, r - 1, n, answers);
                visited[i] = false;
            }
        }
    }

    int print(int[] arr, boolean[] visited, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += arr[i];
            }
        }
        return sum;
    }
}
