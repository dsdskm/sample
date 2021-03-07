package com.kkh.codingtest.greedy;

public class LV2CodingTest_Greedy2_Solution {
    /*
    조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
    ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
    조이스틱을 각 방향으로 움직이면 아래와 같습니다.
    ▲ - 다음 알파벳
    ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
    ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
    ▶ - 커서를 오른쪽으로 이동

    - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
    - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
    - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
    따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
    만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
     */
    public static void main(String args[]) {
        LV2CodingTest_Greedy2_Solution l = new LV2CodingTest_Greedy2_Solution();
        System.out.println(l.solution("JAZ"));
        System.out.println(l.solution("JAN"));
        System.out.println(l.solution("JEROEN"));
        System.out.println(l.solution("AABAA"));
        System.out.println(l.solution("AAAAA"));
        System.out.println(l.solution("ZZZZZ"));
        System.out.println(l.solution("ABABABABAABABABABA"));
    }

    public int solution(String name) {
        /*
        1. 위로 올릴 것인가 내릴 것인가
        2. 좌로 갈 것인가 우로 갈것인가
        3. 마지막이 A인 경우는 굳이 안가도 된다
         */
        char base = 'A';
        int arr[] = new int[name.length()];
        int countA = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c == 'A') {
                countA++;
            }
            int gap = 0;
            if (c > base + 12) {
                gap = 'Z' - c + 1;
            } else {
                gap = c - base;
            }
            arr[i] = gap;
        }
        if (countA == name.length()) {
            return 0;
        }

        // left to right
        int answer1 = 0;
        for (int i = 0; i < arr.length; i++) {
            answer1 += arr[i];
            if (i < arr.length - 1) {
                if (i != arr.length - 1) {
                    answer1++;
                }
            }
        }

        int removeIndex = arr.length - 1;
        while (true) {
            if (removeIndex < 0) {
                break;
            }
            if (arr[removeIndex] == 0) {
                answer1--;
                removeIndex--;
            } else {
                break;
            }
        }

        // right to left
        int answer2 = arr[0] + 1;
        for (int i = arr.length - 1; i > 0; i--) {
            answer2 += arr[i];
            if (i != 1) {
                answer2++;
            }
        }
        removeIndex = 1;
        while (true) {
            if (removeIndex > arr.length - 1) {
                break;
            }
            if (arr[removeIndex] == 0) {
                answer2--;
                removeIndex++;
            } else {
                break;
            }
        }

        //System.out.println("answer1 : " + answer1 + " , answer2 : " + answer2);
        return Math.min(answer1, answer2);
    }

}
