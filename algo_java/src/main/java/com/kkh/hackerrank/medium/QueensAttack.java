package com.kkh.hackerrank.medium;

import com.kkh.Utils;

import java.util.Arrays;

public class QueensAttack {
    public static void main(String args[]) {
        System.out.println(queensAttack(5, 3, 4, 3, new int[][]{
                {5, 5}, {4, 2}, {2, 3}
        }));
//        System.out.println(queensAttack(4, 0, 4, 4, new int[][]{
//        }));
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        /*
        퀸으로부터 8개 방향 끝점을 구한다
        끝점과 퀸의 거리를 계산한다
        끝점과 퀸의 사이에 장애물이 있다면 퀸까지의 거리에서 장애물까지의 거리를 뺀다
         */




        // 장애물을 심어 놓은 배열 생성
        int arr[][] = new int[n][n];
        for (int i = 0; i < obstacles.length; i++) {
            int x = n - obstacles[i][0];
            int y = obstacles[i][1] - 1;
            arr[x][y] = -1;
        }
        Utils.printArr(arr);
        int start_r = n - r_q;
        int start_c = c_q - 1;
        int direction[][] = new int[8][3];

        int directionSum = 0;
        int directLimit = 0;    // max 8;
        for (int i = 0; i < direction.length; i++) {
            direction[i][0] = start_r;
            direction[i][1] = start_c;
            direction[i][2] = 0;    // 0 is ok, -1 is stopped
        }
        int limit = n;
        int fillCount = 0;

        while (true) {
            // up
            if (direction[0][0] - 1 >= 0) {
                direction[0][0] -= 1;
                if (arr[direction[0][0]][direction[0][1]] == -1) {
                    direction[0][2] = -1;
                    directLimit++;
                } else {
                    if (direction[0][2] != -1) {
                        arr[direction[0][0]][direction[0][1]] = 1;
                        directionSum += 1;
                    }
                }
            } else {
                if (direction[0][2] != -1) {
                    directLimit++;
                    direction[0][2] = -1;
                }
            }
            // down
            if (direction[1][0] + 1 < limit) {
                direction[1][0] += 1;
                if (arr[direction[1][0]][direction[1][1]] == -1) {
                    direction[1][2] = -1;
                    directLimit++;
                } else {
                    if (direction[1][2] != -1) {
                        arr[direction[1][0]][direction[1][1]] = 1;
                        directionSum += 1;
                    }
                }
            } else {
                if (direction[1][2] != -1) {
                    directLimit++;
                    direction[1][2] = -1;
                }
            }
            // left
            if (direction[2][1] - 1 >= 0) {
                direction[2][1] -= 1;
                if (arr[direction[2][0]][direction[2][1]] == -1) {
                    direction[2][2] = -1;
                    directLimit++;
                } else {
                    if (direction[2][2] != -1) {
                        arr[direction[2][0]][direction[2][1]] = 1;
                        directionSum += 1;
                    }
                }
            } else {
                if (direction[2][2] != -1) {
                    directLimit++;
                    direction[2][2] = -1;
                }
            }
            // right
            if (direction[3][1] + 1 < limit) {
                direction[3][1] += 1;
                if (arr[direction[3][0]][direction[3][1]] == -1) {
                    direction[3][2] = -1;
                    directLimit++;
                } else {
                    if (direction[3][2] != -1) {
                        arr[direction[3][0]][direction[3][1]] = 1;
                        directionSum += 1;
                    }
                }
            } else {
                if (direction[3][2] != -1) {
                    directLimit++;
                    direction[3][2] = -1;
                }
            }


            // left up
            if (direction[4][1] - 1 >= 0 && direction[4][0] - 1 >= 0) {
                direction[4][0] -= 1;
                direction[4][1] -= 1;
                if (arr[direction[4][0]][direction[4][1]] == -1) {
                    direction[4][2] = -1;
                    directLimit++;
                } else {
                    if (direction[4][2] != -1) {
                        arr[direction[4][0]][direction[4][1]] = 1;
                        directionSum += 1;
                    }
                }
            } else {
                if (direction[4][2] != -1) {
                    directLimit++;
                    direction[4][2] = -1;
                }
            }
            // right up
            if (direction[5][1] + 1 < limit && direction[5][0] - 1 >= 0) {
                direction[5][0] -= 1;
                direction[5][1] += 1;
                if (arr[direction[5][0]][direction[5][1]] == -1) {
                    direction[5][2] = -1;
                    directLimit++;
                } else {
                    if (direction[5][2] != -1) {
                        arr[direction[5][0]][direction[5][1]] = 1;
                        directionSum += 1;
                    }
                }
            } else {
                if (direction[5][2] != -1) {
                    directLimit++;
                    direction[5][2] = -1;
                }
            }
            // left down
            if (direction[6][1] - 1 >= 0 && direction[6][0] + 1 < limit) {
                direction[6][0] += 1;
                direction[6][1] -= 1;
                if (arr[direction[6][0]][direction[6][1]] == -1) {
                    direction[6][2] = -1;
                    directLimit++;
                } else {
                    if (direction[6][2] != -1) {
                        arr[direction[6][0]][direction[6][1]] = 1;
                        directionSum += 1;
                    }
                }
            } else {
                if (direction[6][2] != -1) {
                    directLimit++;
                    direction[6][2] = -1;
                }
            }
            // right down
            if (direction[7][1] + 1 < limit && direction[7][0] + 1 < limit) {
                direction[7][0] += 1;
                direction[7][1] += 1;
                if (arr[direction[7][0]][direction[7][1]] == -1) {
                    direction[7][2] = -1;
                    directLimit++;
                } else {
                    if (direction[7][2] != -1) {
                        arr[direction[7][0]][direction[7][1]] = 1;
                        directionSum += 1;
                    }
                }
            } else {
                if (direction[7][2] != -1) {
                    directLimit++;
                    direction[7][2] = -1;
                }
            }
            if (directLimit == 8) {
                break;
            }

        }


        return directionSum;
    }
}
