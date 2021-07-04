package com.kkh.algo.codejam.online_2021_1;

import com.kkh.Utils;

import java.io.*;
import java.util.Arrays;

public class ProblemD {
    /*
    Albert는 L대학에서 주최하는 Hackathon 행사 진행을 도와주기로 했는데, 사회적 거리 두기 방침에 따라 모든 참가자들을 최대한 멀리 떨어트려 좌석 배정을 해주려 한다.
    이를 위해 아주 길다란 복도를 따라 특정 위치에 모니터, 책상, 의자를 두는 식으로 좌석을 배정하고, 각 좌석에는 최대 한 팀만 착석할 수 있다.
    총 s개의 팀이 행사에 참가하고, 복도를 따라 총 n곳에 전원 공급이 가능한 콘센트가 설치되어 있다 -- 좌석은 반드시 콘센트가 설치된 곳에만 할 수 있다.
    편의상  콘센트가 설치된 지점들의 위치를 x[1], x[2], ..., x[n] 이라 하자 (각 x[i]는 복도 입구로 부터의 거리를 나타낸다).
    즉, i번째 콘센트는 복도의 입구로부터 x[i] 만큼 떨어진 곳에 있다.

    Albert는 n개의 콘센트 위치 중 s개를 선택하여 좌석을 선택하되, 가장 가까운 두 좌석의 거리 (D라 하자)가 최대가 되도록 하고 싶다.
    예를 들어, n = 3, s = 3 이고 x = [10, 100, 200]이라 하자. 이 경우 n = s 이므로 각 콘센트 위치에 좌석을 설치해야 한다. 가장 가까운 두 좌석의 거리는 (100 - 10) = 90 이다.
    다른 예로, n = 6, s = 4 이고 x = [11, 19, 24, 26, 29, 30]이라 하자. 이 경우, x[1] = 11, x[2] = 19, x[3] = 24, x[4] = 29 각각에 좌석을 설치하면 가장 가까운 두 좌석의 거리는 5가 된다.
    혹은, x[1] = 11, x[2] = 19, x[3] = 24, x[4] = 30을 선택하는 것도 가능하다. 가장 가까운 두 좌석의 거리가 6 이상이 되도록 4개의 좌석을 설치하는 방법은 없다.
    입력으로 n, s, 그리고 x[1], ..., x[n]이 주어지면 가능한 가장 큰 D값을 출력하는 프로그램을 작성하시오.

    3 3
    10 100 200
    7 3
    28 11 17 19 21 22 23
    6 4
    11 19 24 26 29 30

     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            String arr[] = br.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            int s = Integer.parseInt(arr[1]);
            String arr2[] = br.readLine().split(" ");
            int result = solution(n, s, arr2);
            bw.write("" + result + "\n");
            bw.flush();
        }


    }

    public static int solution(int n, int s, String stringArr[]) {
        /*

        s= 2이면 시작과 끝 값의 차이이다
        D의 범위는 1<D<arr.length
        D값을 반으로 줄여가보면서, 가능여부를 계속 체크한다
        첫번째 원소부터해서 D만큼 거리를 유지하면서 S 카운트를 충족하는지 체크한다
        충족하는 경우 D를 늘리고 충족하지 않는 경우 D를 줄인다


         */
        int arr[] = new int[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            arr[i] = Integer.parseInt(stringArr[i]);
        }
        Arrays.sort(arr);
        int ret = 0;
        if (s == 2) {
            ret = arr[arr.length - 1] - arr[0];
        } else {
            int left = 1;
            int right = arr[arr.length - 1];
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                boolean c = check(arr, mid, s);
                if (c) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                ret = right;
            }
        }


        return ret;
    }

    public static boolean check(int arr[], int d, int s) {
        int prv = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prv >= d) {
                count++;
                prv = arr[i];
            }
        }
        return count >= s;
    }

}
