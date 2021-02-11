package com.kkh.codingtest.level1_test;

import java.util.Stack;

public class Crane {

    public static void main(String args[]) {
        Crane c = new Crane();
        int res = c.solution(
                new int[][]{
                        {0, 0, 0, 0, 0}
                        , {0, 0, 1, 0, 3}
                        , {0, 2, 5, 0, 1}
                        , {4, 2, 4, 4, 2}
                        , {3, 5, 1, 3, 1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4});
//        int res = c.solution(
//                new int[][]{
//                        {0, 0, 0, 0, 0}
//                        , {0, 0, 0, 0, 0}
//                        , {1, 1, 1, 1, 1}
//                        , {1, 1, 1, 1, 1}
//                        , {1, 1, 1, 1, 1}},
//                new int[]{1,2,3,4,5});

        System.out.println(res);
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int col = moves[i] - 1;
            for (int row = 0; row < board.length; row++) {
                int value = board[row][col];
//                System.out.println("row : " + row + " ,moves : " + (col + 1) + ", col : " + col + " , value : " + value);
                if (value != 0) {
                    if (stack.isEmpty()) {
                        stack.push(value);
                        board[row][col] = 0;
                    } else {
//                        System.out.println("stack peek : " + stack.peek() + " , value : " + value);
                        if (stack.peek() == value) {
                            stack.pop();
//                            System.out.println("poped: " + stack.peek());
                            answer += 2;
                        } else {
//                            System.out.println("pushed : " + value);
                            stack.push(value);
                        }
                        board[row][col] = 0;
                    }
                    break;

                }
            }
//            System.out.println();
        }
        return answer;

    }

}
