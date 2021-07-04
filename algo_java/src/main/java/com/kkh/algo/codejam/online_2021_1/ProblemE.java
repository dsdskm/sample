package com.kkh.algo.codejam.online_2021_1;

import java.io.*;
import java.util.HashMap;

public class ProblemE {
    /*

    길이 n+1인 배열 A가 1부터 n-1까지의 정수를 한 번씩 포함하고, n을 두 번 포함하면 배열 A는 좋은 배열이다.
    길이가 n+1인 좋은 배열의 개수는 정확히 (n+1)!/2 개 존재한다.
    -> 순열

   A가 길이 n+1인 좋은 배열이라면, Score(A) 는 다음과 같이 정의 된다: 1 ≤ i < j ≤ n+1 과 A[i] < A[j] 를 만족하는 쌍 (i, j)의 개수.
    만약 A = [1, 2, 3, ..., n-1, n, n] 이라면 Score(A)는 (n+2)(n-1)/2로 최대가 되며, A = [n, n, n-1, n-2, ..., 2, 1] 이라면 Score(A) = 0으로 최소가 된다.

    Albert는 n과 두 개의 정수 a, b 가 주어졌을 때, a ≤ Score(A) ≤ b 를 만족하는 길이 n+1인 좋은 배열의 개수를 세는 문제를 풀고 싶다.

    예를 들어, n = 3, a = 2, b = 3 이라 하자. 총 12개의 좋은 배열 중 a ≤ Score(A) ≤ b를 만족하는 길이 4인 좋은 배열의 개수는 6개이다.

    A = [1, 2, 3, 3]: Score(A) = 5                      // 1,2 / 1,3 / 2,3
    A = [1, 3, 2, 3]: Score(A) = 4
    A = [1, 3, 3, 2]: Score(A) = 3 (만족)
    A = [2, 1, 3, 3]: Score(A) = 4
    A = [2, 3, 1, 3]: Score(A) = 3 (만족)
    A = [2, 3, 3, 1]: Score(A) = 2 (만족)
    A = [3, 1, 2, 3]: Score(A) = 3 (만족)
    A = [3, 1, 3, 2]: Score(A) = 2 (만족)
    A = [3, 2, 1, 3]: Score(A) = 2 (만족)
    A = [3, 2, 3, 1]: Score(A) = 1
    A = [3, 3, 1, 2]: Score(A) = 1
    A = [3, 3, 2, 1]: Score(A) = 0
    입력으로 n, a, b 가 주어졌을 때, a ≤ Score(A) ≤ b 를 만족하는 길이 n+1인 좋은 배열 A의 개수를 출력하는 프로그램을 작성하시오.

     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
//        int T = Integer.parseInt(br.readLine());
//        for (int i = 0; i < T; ++i) {
//            String arr[] = br.readLine().split(" ");
//            int n = Integer.parseInt(arr[0]);
//            int a = Integer.parseInt(arr[1]);
//            int b = Integer.parseInt(arr[2]);
//            int result = solution(n, a, b);
//            bw.write("" + result + "\n");
//            bw.flush();
//        }
//        System.out.println(solution(3, 2, 3));
//        System.out.println(solution(4, 0, 1));
        System.out.println(solution(4, 4, 5));
//        System.out.println(solution(8, 10, 20));
//        System.out.println(solution(12, 0, 77));

    }

    public static int solution(int n, int a, int b) {
        count = 0;
        /*
        1. 좋은 배열을 생성 한다
        2.
         */

        int arr[] = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = i;
            } else {
                arr[i] = i + 1;
            }
        }

        boolean isVisited[] = new boolean[arr.length];
        int output[] = new int[arr.length];
        perm(arr, isVisited, output, 0, arr.length, "", a, b);

        return count;
    }

    public static HashMap<String, Boolean> map = new HashMap<>();
    public static int count = 0;

    public static void perm(int arr[], boolean[] isVisited, int output[], int depth, int len, String str, int a, int b) {
        if (depth == len) {
//            System.out.println("str : "+str);
            if (map.containsKey(str)) {
                return;
            } else {
                map.put(str, true);
            }
            print(output, a, b, str);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                output[depth] = arr[i];
                perm(arr, isVisited, output, depth + 1, len, str.concat(String.valueOf(arr[i])), a, b);
                isVisited[i] = false;

            }
        }
    }

    private static void print(int[] arr, int a, int b, String str) {
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    c++;
                }
            }
        }
        System.out.println("str : " + str + " , c : " + c);
        if (a <= c && c <= b) {
            count++;
        }
    }


}
