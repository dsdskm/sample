package com.kkh.codingtest.level1_test;

public class Keypad {
    // https://programmers.co.kr/learn/courses/30/lessons/67256
    public static void main(String[] args) {
        Keypad k = new Keypad();
        //System.out.println(k.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        //System.out.println(k.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(k.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));

        /*
        1 2 3
        4 5 6
        7 8 9
        * 0 #
        맨 처음 왼손 엄지는 *
        맨 처음 오른손 엄지는 #

        엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
        왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
        오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
        가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
        4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
         */
    }

    public String solution(int[] numbers, String hand) {
        /*
        1. 2차원 배열로 키패드 선언하고 매번 오른손,왼손 인덱스를 기억한다(시작 인덱스는 왼손[0,3],오른손[2,3]
        2. 1,4,7은 왼손으로 3,6,9는 오른손 2,5,8,0 은 가운데
        3. 왼손/오른손 입력시마다 각 행열 인덱스를 기억한다
        4. 가운데 입력을 하는 경우 매 현재 손가락 위치(행열 인덱스) 와의 거리를 비교한다
        5. 거리가 같은 경우 hand를 기준으로 선택
        6. 매 이동시 L,R 문자열을 더한다
         */
        String L = "L";
        String R = "R";
        String light = "left";
        String right = "right";

        int[] leftIndex = new int[]{0, 3};
        int[] rightIndex = new int[]{2, 3};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            String append = "";
            if (number == 1 || number == 4 || number == 7) {
                // 왼쪽
                leftIndex[0] = 0;
                switch (number) {
                    case 1 -> leftIndex[1] = 0;
                    case 4 -> leftIndex[1] = 1;
                    case 7 -> leftIndex[1] = 2;
                }
                append = L;

            } else if (number == 3 || number == 6 || number == 9) {
                // 오른쪽
                rightIndex[0] = 2;
                switch (number) {
                    case 3 -> rightIndex[1] = 0;
                    case 6 -> rightIndex[1] = 1;
                    case 9 -> rightIndex[1] = 2;
                }
                append = R;
            } else {
                // 가운데
                int row = 0;
                int col = 1;
                switch (number) {
                    case 2 -> row = 0;
                    case 5 -> row = 1;
                    case 8 -> row = 2;
                    case 0 -> row = 3;
                }
                int distanceOfLeft = Math.abs(row - leftIndex[1]) + Math.abs(col - leftIndex[0]);
                int distanceOfRight = Math.abs(row - rightIndex[1]) + Math.abs(col - rightIndex[0]);
                if (distanceOfLeft > distanceOfRight) {
                    append = R;
                    rightIndex[0] = col;
                    rightIndex[1] = row;
                } else if (distanceOfLeft < distanceOfRight) {
                    append = L;
                    leftIndex[0] = col;
                    leftIndex[1] = row;
                } else {
                    if (light.equalsIgnoreCase(hand)) {
                        append = L;
                        leftIndex[0] = col;
                        leftIndex[1] = row;
                    } else {
                        append = R;
                        rightIndex[0] = col;
                        rightIndex[1] = row;
                    }
                }
            }
            sb.append(append);
        }
        return sb.toString();
    }
}
