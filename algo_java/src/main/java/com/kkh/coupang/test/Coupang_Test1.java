package com.kkh.coupang.test;

public class Coupang_Test1 {
    public static void main(String args[]) {
        new Coupang_Test1();
    }

    public Coupang_Test1() {
        System.out.println(solution(new int[][]{
                        {0, 3}, {1, 1}, {1, 5}, {2, 2}, {3, 3}, {4, 0}},
                new int[]{1, 4}, new int[]{4, 1}));
//        System.out.println(solution(new int[][]{
//                        {0, 3}, {1, 1}, {1, 5}, {2, 2}, {3, 3}, {4, 0}},
//                new int[]{3, 4}, new int[]{0, 0}));
    }

    public int solution(int[][] location, int[] s, int[] e) {
        int answer = 0;

        // 시작 위치와 끝 위치를 기준으로 사각형 범위를 만들고, 그 범위내에 존재하는 위치를 카운트

        for (int i = 0; i < location.length; i++) {
            int x = location[i][0];
            int y = location[i][1];
            // 좌에서 우로 가는 경우
            // 우에서 좌로 가는 경우
            if (s[0] < e[0]) {
                // 좌에서 우로 가는 경우
                if (x >= s[0] && x <= e[0]) {

                    if (s[1] > e[1]) {
                        // 좌상단->우하단
                        if (y <= s[1] && y >= e[1]) {
                            answer++;
                        }
                    } else {
                        // 좌하단->우상단
                        if (y >= s[1] && y <= e[1]) {
                            answer++;
                        }
                    }
                }
            } else {
                // 우에서 좌로 가는 경우
                if (x <= s[0] && x >= e[0]) {

                    if (s[1] > e[1]) {
                        // 우상단->좌하단
                        if (y <= s[1] && y >= e[1]) {
                            answer++;
                        }
                    } else {
                        // 우하단->좌상단
                        if (y >= s[1] && y <= e[1]) {
                            answer++;
                        }
                    }
                }

            }
        }

        return answer;
    }
}
