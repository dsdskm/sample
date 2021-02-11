package com.kkh.codingtest.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

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
    }


    public int solution(int[] priorities, int location) {
        /*
        1. 인덱스 값으로 데크로 생성
        2. 첫번쨰 원소를 나머지 원소들과 비교하여 더 큰 값이 있을 경우 꼬리로 보낸다
        3. 더 큰 값이 없을 경우 제거
        4. 제거할때 최초 입력된 인덱스와 비교
        5. 전체 반복 횟수를 리턴
         */
        Deque<Integer> test = new ArrayDeque<Integer>();
        int answer =0;
        while(true){

        }
        return answer;
    }

}
