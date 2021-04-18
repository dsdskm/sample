package com.kkh.algo.codingtest.level1_test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Crane {
    //https://programmers.co.kr/learn/courses/30/lessons/64061

    /*

    게임개발자인 "죠르디"는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
    "죠르디"는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.
    게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다.
    집어 올린 인형은 바구니에 쌓이게 되는 데, 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.

    만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다.
    크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
    또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다.
    게임 화면의 격자의 상태가 담긴 2차원 배열 board
    인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves
    크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록

     */
    public static void main(String args[]) {
        Crane c = new Crane();
        System.out.println(c.solution(new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 3},
                        {0, 2, 5, 0, 1},
                        {4, 2, 4, 4, 2},
                        {3, 5, 1, 3, 1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4}
        ));

        /*
        4
        2
        3
        1 -- 터짐
        1
        3
        4
         */


        /*
        0. NxN 격자가 주어진다
        1. 열단위로 큐를 만든다. 0은 offer 하지 않는다
        2. moves를 반복하면서 각 index(열)의 stack에서 peek을 확인한다
        3. peek이 넣으려는 값과 같으면 poll만 한다
        4. peek이 넣으려는 값과 다르면 큐에 offer 한다
        5. moves를 모두 반복한 후에 바구니 큐의 사이즈를 리턴한다
         */

    }


    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        //1. 열단위로 큐를 만든다. 0은 push 하지 않는다
        Queue<Integer>[] queues = new LinkedList[board.length];
        for (int i = 0; i < board.length; i++) {
            queues[i] = new LinkedList();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    queues[j].offer(board[i][j]);
                }
            }
        }

        Stack<Integer> resultStack = new Stack<>();

        //2. moves를 반복하면서 각 index(열)의 stack에서 peek을 확인한다
        for (int i = 0; i < moves.length; i++) {
            int move = moves[i];
            // 넣으려는 값이 없으면 넘어간다
            if (queues[move-1].size() == 0) {
                continue;
            }

            int poll = queues[move-1].poll();     // 넣으려는 값
            if (resultStack.size() == 0 || resultStack.peek() != poll) {
                //3. peek이 넣으려는 값과 다르면 stack에 push한다
                resultStack.push(poll);
            } else {
                //4. peek이 넣으려는 값과 같으면 pop만 한다
                resultStack.pop();
                answer +=2;
            }
        }
        //5. moves를 모두 반복한 후에 바구니 moves 사이즈 - stack의 사이즈를 리턴한다
        return answer;
    }

}
