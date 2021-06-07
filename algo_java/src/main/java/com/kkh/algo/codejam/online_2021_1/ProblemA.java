package com.kkh.algo.codejam.online_2021_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ProblemA {
    /*
    Albert는 QWERTY 키보드를 이용해 (위 그림 참고) 영문 대문자로 ('A'-'Z') 구성된 문자열을 입력하고 싶다.
    아직 키보드 만지는 것이 서툰 Albert는 왼쪽 검지만을 이용해 버튼을 누르는 버릇이 있다.
    각 버튼을 눌렀다 떼어서 글자 하나를 입력하는데 1초가 걸리고, 검지를 한 버튼에서 인접한 다른 버튼으로 옮기는데는 2초가 걸린다고 하자 (문자열을 입력하는 동안 손가락은 항상 키보드 버튼 위에서만 이동한다고 하자).
    각 버튼의 주변에는 최대 6개의 인접한 버튼이 있을 수 있다. 가령, 검지를 S버튼에서 A, W, E, D, X, 혹은 Z로 옮기는 경우 2초가 걸린다.
    Albert가 어떤 문자열을 입력하기 위해서는 먼저 왼쪽 검지를 해당 문자열의 첫 글자에 해당하는 버튼 위에 올린 후, 그 때 부터 시간을 측정한다.

    QWERTYUIOP
    ASDFGHJKL
    ZXCVBNM
0,1 2,4
    QWERTY      16
    LOM         9
    FFGGFF      10
    VGTRDCF     19
    MPML        20
    */
    static String[] KEYBOARD = new String[]{"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};

    public static void main(String args[]) {
        System.out.println(solution("QWERTY"));
    }

    static int time = 0;
    static int remain = 0;

    public static int solution(String str) {
        /*
        ================
        1. 왼손으로 첫 키 위에 이동한다 - 0초
        2. 왼손으로 누르고 뗀다 - 1초
        3. 인접한 한 칸으로 이동한다 2초
        4. 더 이동해야한다 +2초

        1. 첫 키의 인덱스를 찾는다
        2. 모든 방향으로 다음 키를 찾아 탐색한다
        3. 가장 빠른 시간에 찾은 방법을 계산한다
        4. 인덱스를 업데이트 한다
        5. 다찾을 때 까지 검색한다
         */
        int index[] = new int[]{-1, -1};
        for (int i = 0; i < KEYBOARD.length; i++) {
            for (int j = 0; j < KEYBOARD[i].length(); j++) {
                if (str.charAt(0) == KEYBOARD[i].charAt(j)) {
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        remain = str.length();
        HashSet<Character> checkedSet = new HashSet<>();
        searchKey(str, index[0], index[1], checkedSet,0);
        System.out.println("time : " + time);
        int ret = 0;
        return ret;
    }

    private static void searchKey(String str, int i, int j, HashSet<Character> checkedSet,int move) {
        // 다 찾았으면 리턴
        if (str.length() == 0) {
            return;
        }

        if (remain == 0) {
            return;
        }


        // i, j 범위 검사
        if (i < 0 || i >= KEYBOARD.length) {
            return;
        }
        if (j < 0 || j >= KEYBOARD[i].length()) {
            return;
        }
        char c = str.charAt(0);
        char key = KEYBOARD[i].charAt(j);

        if (checkedSet.contains(key)) {
            return;
        }
        String next = str;
        checkedSet.add(key);
        if (c == key) {
            // 찾았으면 다음 문자열 탐색
            // 검색한 set 은 초기화
            checkedSet.clear();
            next = str.substring(1);
            System.out.println("move : "+i+" , "+j);
            time++;
            remain--;
        } else {
            // 못찾았으면 이동
            move+=2;
        }
        searchKey(next, i + 1, j, checkedSet,move);
        searchKey(next, i + 1, j + 1, checkedSet,move);
        searchKey(next, i + 1, j - 1, checkedSet,move);
        searchKey(next, i, j + 1, checkedSet,move);
        searchKey(next, i, j - 1, checkedSet,move);
        searchKey(next, i - 1, j, checkedSet,move);
        searchKey(next, i - 1, j + 1, checkedSet,move);
        searchKey(next, i - 1, j - 1, checkedSet,move);
    }

}
