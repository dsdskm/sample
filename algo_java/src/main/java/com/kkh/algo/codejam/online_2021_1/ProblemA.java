package com.kkh.algo.codejam.online_2021_1;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

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

    QWERTY      16
    LOM         9
    FFGGFF      10
    VGTRDCF     19
    MPML        20
    */
    static String[] KEYBOARD = new String[]{"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Character, int[]> keySet = new HashMap<>();

    public static void main(String args[]) throws IOException {
        init();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            String s = br.readLine().trim();
            int result = solution(s);
            bw.write("" + result + "\n");
            bw.flush();
        }

    }

    public static void init() {
        int index[] = new int[]{-1, -1};
        for (int i = 0; i < KEYBOARD.length; i++) {
            for (int j = 0; j < KEYBOARD[i].length(); j++) {
                index[0] = i;
                index[1] = j;
                keySet.put(KEYBOARD[i].charAt(j), new int[]{i, j});
            }
        }
    }

    public static int solution(String str) {
        /*
        ================
        1. 왼손으로 첫 키 위에 이동한다 - 0초
        2. 왼손으로 누르고 뗀다 - 1초
        3. 인접한 한 칸으로 이동한다 2초
        4. 더 이동해야한다 +2초

        1. 모든 키의 좌표를 저장한다
        2. 키간의 거리 계산 식을 구한다
        3. 방향별로 계산식을 구한다
        4. 주어진 문자열을 순회하면서 시간을 누적 계산한다
        QWERTYUIOP
        ASDFGHJKL
        ZXCVBNM

       1)G->W   (1,4) -> (0,1) 4->3         dX > 0   dY > 0
       2)G->S   (1,4) -> (1,1) 3            dX = 0   dY > 0
       3)G->X   (1,4) -> (2,1) 4->3         dX < 0   dY > 0
       4)G->U   (1,4) -> (0,6) 3->2         dX > 0   dY < 0
       5)G->J   (1,4) -> (1,6) 2
       6)G->M   (1,4) -> (2,6) 3->2
       7)R->M   (0,3) => (2,6) 5->3
       8)R->X   (0,3) => (2,1) 4->2
       -> 좌,우,상,하 한방향으로만 이동 -> 단순 빼기
       -> max((x1-x2),(y1-y2))
        */

        char prvC = str.charAt(0);
        int prvIndex[] = keySet.get(prvC);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            int curIndex[] = keySet.get(c);
            int currentDiffX = curIndex[0] - prvIndex[0];
            int currentDiffY = curIndex[1] - prvIndex[1];
            //System.out.println("currentDiffX :"+currentDiffX+" , currentDiffY : "+currentDiffY);
            if ((currentDiffX >= 0 && currentDiffY >= 0) || (currentDiffX < 0 && currentDiffY < 0)) {
                count += Math.abs(currentDiffX + currentDiffY)*2;
            } else {
                count += Math.max(Math.abs(currentDiffX),Math.abs(currentDiffY))*2;
            }
            count++;
            prvIndex = curIndex;
        }
        return count;
    }
}
