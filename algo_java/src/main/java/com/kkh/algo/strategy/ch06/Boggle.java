package com.kkh.algo.strategy.ch06;

public class Boggle {
    /*
    보글 게임판에서 단어르 찾는 재귀 알고리즘
     */
    public static void main(String args[]) {
        System.out.println("PRETTY : "+solution(new char[][]{
                {'U', 'R', 'L', 'P', 'M'},
                {'X', 'P', 'R', 'E', 'T'},
                {'G', 'I', 'A', 'E', 'T'},
                {'X', 'T', 'N', 'Z', 'Y'},
                {'X', 'O', 'Q', 'R', 'S'}
        }, "PRETTY"));
        System.out.println("GIRL : "+solution(new char[][]{
                {'U', 'R', 'L', 'P', 'M'},
                {'X', 'P', 'R', 'E', 'T'},
                {'G', 'I', 'A', 'E', 'T'},
                {'X', 'T', 'N', 'Z', 'Y'},
                {'X', 'O', 'Q', 'R', 'S'}
        }, "GIRL"));
        System.out.println("REPEAT : "+solution(new char[][]{
                {'U', 'R', 'L', 'P', 'M'},
                {'X', 'P', 'R', 'E', 'T'},
                {'G', 'I', 'A', 'E', 'T'},
                {'X', 'T', 'N', 'Z', 'Y'},
                {'X', 'O', 'Q', 'R', 'S'}
        }, "REPEAT"));
        System.out.println("KARA : "+solution(new char[][]{
                {'U', 'R', 'L', 'P', 'M'},
                {'X', 'P', 'R', 'E', 'T'},
                {'G', 'I', 'A', 'E', 'T'},
                {'X', 'T', 'N', 'Z', 'Y'},
                {'X', 'O', 'Q', 'R', 'S'}
        }, "KARA"));
        System.out.println("PANDORA : "+solution(new char[][]{
                {'U', 'R', 'L', 'P', 'M'},
                {'X', 'P', 'R', 'E', 'T'},
                {'G', 'I', 'A', 'E', 'T'},
                {'X', 'T', 'N', 'Z', 'Y'},
                {'X', 'O', 'Q', 'R', 'S'}
        }, "PANDORA"));
        System.out.println("GIAZAPX : "+solution(new char[][]{
                {'U', 'R', 'L', 'P', 'M'},
                {'X', 'P', 'R', 'E', 'T'},
                {'G', 'I', 'A', 'E', 'T'},
                {'X', 'T', 'N', 'Z', 'Y'},
                {'X', 'O', 'Q', 'R', 'S'}
        }, "GIAZAPX"));
    }


    public static boolean solution(char board[][], String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (hasWord(i, j, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final int dx[] = {-1, -1, -1, 1, 1, 1, 0, 0};
    public static final int dy[] = {-1, 0, 1, -1, 0, 1, -1, 1};

    public static boolean hasWord(int x, int y, String word, char[][] board) {
        if (x < 0 || y < 0 || x >= board[0].length || y >= board.length) {
            // x,y 범위 체크
            return false;
        } else if (board[x][y] != word.charAt(0)) {
            // 첫글자 다르면 false
            return false;
        } else if (word.length() == 1) {
            // string을 계속 substring 하여 넘기므로 size ==1 이면 true
            return true;
        } else {
            // 다른 인접 글자 체크
            for (int i = 0; i < 8; ++i) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (hasWord(nextX, nextY, word.substring(1), board)) {
                    return true;
                }
            }
        }
        return false;
    }
}
