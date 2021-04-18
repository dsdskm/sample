package com.kkh.algo.codingtest.stack_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LV2CodingTest_StackQueue4_Solution {

    /*
    일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다.
    그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
    이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
    이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

    1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
    2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
    3. 그렇지 않으면 J를 인쇄합니다.


     */
    public static void main(String args[]) {
        LV2CodingTest_StackQueue4_Solution s = new LV2CodingTest_StackQueue4_Solution();
        System.out.println(s.solution(new int[]{2, 1, 3, 2}, 2));           // 1
        System.out.println(s.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));           // 5
        /*
        value               index
        2   1   3/   2       0   1   2   3
        1   3   2   2       1   2   3   0
        3   2   2   1       2   3   0   1
            2   2   1           3   0   1
                2   1               0   1
                    1                   1

         */


//        System.out.println(s.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));       // 5
    }


    public int solution(int[] priorities, int location) {
        /*
        1. 인덱스 값으로 데크로 생성
        2. 첫번쨰 원소를 나머지 원소들과 비교하여 더 큰 값이 있을 경우 꼬리로 보낸다
        3. 더 큰 값이 없을 경우 제거
        4. 제거할때 최초 입력된 인덱스와 비교
        5. 전체 반복 횟수를 리턴
         */
        Deque<Integer> index_list = new ArrayDeque<Integer>();
        ArrayList<Integer> value_list = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            // 인덱스를 넣는다
            index_list.add(i);

            // 값을 넣는다.
            value_list.add(priorities[i]);
        }


        int answer = 0;
        while (true) {
            if (index_list.size() == 0) {
                break;
            }
            // 매번 첫번째 값과 나머지 값들을 비교
            // 마지막에 넣든 아예 빼든 첫번째 값은 무조건 뺀다
            int firstIndex = index_list.pollFirst();
            int firstValue = value_list.get(0);
//            System.out.println("firstIndex : " + firstIndex + " , firstValue : " + firstValue);
            // 첫번쨰 값 vs 나머지 값들 비교를 한다
            // 첫번째 값보다 큰 값이 존재하면 index_list의 last에 index 추가, value_list의 첫번째 값지우고 last에 값추가
            boolean hasBigOne = false;
            for (int i = 1; i < value_list.size(); i++) {
                int value = value_list.get(i);
//                System.out.println("    firstValue : " + firstValue + " , value : " + value);
                if (firstValue < value) {
                    index_list.addLast(firstIndex);
                    value_list.remove(0);
                    value_list.add(firstValue);
                    hasBigOne = true;
                    break;
                }
            }

            // 첫번째 값보다 큰 값이 없다면 이밎 index_list에서는 지웠으므로 value_list의 첫번째 값만 지운다
            if (!hasBigOne) {
                answer++;
                value_list.remove(0);
                // 값을 제거할때의 첫번째 인덱스와 입력된 값이 같으면 break;
//                System.out.println("firstIndex : " + firstIndex + " , location : " + location);
                if (firstIndex == location) {
                    break;
                }
            }


        }
        return answer;
    }

}
