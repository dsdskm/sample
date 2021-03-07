package com.kkh.codingtest.greedy;

import java.util.HashSet;
import java.util.Set;

public class LV1CodingTest_Greedy1_Solution {
    /*
    점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
    학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
    예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
    체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

    전체 학생의 수 n,
    체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
    여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,

    체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

     */
    public static void main(String args[]) {
        LV1CodingTest_Greedy1_Solution l = new LV1CodingTest_Greedy1_Solution();
        System.out.println(l.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));          // 5

    }

    public int solution(int n, int[] lost, int[] reserve) {

        /*
        1. lost = reverse 먼저 제겋나다
        2. 도난당한 케이스에서 순회한다.
         */

        int lost1 = 0;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[i] = -1;
                    lost1 += 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < lost.length; i++) {
            // 답 하나가 끼워들워 갈 수 있는지 각각 확인한다
            // 이미 빌려준 친구는 -1로 한다
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
                    count++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        int answer = n - lost.length + lost1 + count;
        System.out.println("answer : " + answer);


        return answer;
    }
}
