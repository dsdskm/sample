package com.kkh.coupang.test;

public class CoupangTest_Demo {
    public static void main(String args[]) {
        new CoupangTest_Demo();
    }

    public CoupangTest_Demo() {
//        solution(new int[][]{
//                {1, 4},
//                {3, 10},
//                {3, 4}
//        });
        solution(new int[][]{
                {1, 1},
                {2, 2},
                {1, 2}
        });
    }

    public int[] solution(int[][] v) {
        int[] answer = {};
        /*
        1   4
        1   10
        3   4
        3   10
         */
        int x1, x2, x3, x4 = 0;
        int y1, y2, y3, y4 = 0;

        x1 = v[0][0];
        x2 = v[1][0];
        x3 = v[2][0];

        y1 = v[0][1];
        y2 = v[1][1];
        y3 = v[2][1];

        int x_arr[] = new int[3];
        int y_arr[] = new int[3];

        x_arr[0] = x1;
        x_arr[1] = x2;
        x_arr[2] = x3;

        y_arr[0] = y1;
        y_arr[1] = y2;
        y_arr[2] = y3;

        int x1_count = 0;
        int y1_count = 0;
        for (int i = 0; i < x_arr.length; i++) {
            if (x1 == x_arr[i]) {
                x1_count++;
            }
            if (y1 == y_arr[i]) {
                y1_count++;
            }


        }

        if (x1_count == 1) {
            // x1이 하나만 정의 되어 있다.
            x4 = x1;
        } else {
            // x1이 두개 정의 되어 있다.

            if (x1 == x2) {
                x4 = x3;
            } else {
                x4 = x2;
            }
        }

        if (y1_count == 1) {
            // y1이 하나만 정의되어 있다.
            y4 = y1;
        } else {
            // y1이 두개 정의되어 있다.
            if (y1 == y2) {
                y4 = y3;
            } else {
                y4 = y2;
            }
        }
//        System.out.println("x1 = " + x1 + " , x2 = " + x2 + " , x3 = " + x3 + " , x4 = " + x4);
//        System.out.println("y1 = " + y1 + " , y2 = " + y2 + " , y3 = " + y3 + " , y4 = " + y4);
        answer = new int[]{x4, y4};
        return answer;
    }
}
