package com.kkh.codingtest.level1_test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PocketMon {
    // https://programmers.co.kr/learn/courses/30/lessons/1845

    public static void main(String args[]) {
        PocketMon p = new PocketMon();
        System.out.println(p.solution(new int[]{3, 1, 2, 3}));      //2
        System.out.println(p.solution(new int[]{3, 3, 3, 2, 2, 4}));      //3
        System.out.println(p.solution(new int[]{3, 3, 3, 2, 2, 2}));      //2
        /*
        N마리중 N/2마리를 가져간다
        가장 많은 종류의 포켓몬을 선택하는 방법을 찾는다
        그때의 포켓몬 종류 번호 개수를 리턴

        4마리중 2마리를 고르는 방법(3,1,2,3)
        첫 번째(3번), 두 번째(1번) 폰켓몬을 선택
        첫 번째(3번), 세 번째(2번) 폰켓몬을 선택
        첫 번째(3번), 네 번째(3번) 폰켓몬을 선택
        두 번째(1번), 세 번째(2번) 폰켓몬을 선택
        두 번째(1번), 네 번째(3번) 폰켓몬을 선택
        세 번째(2번), 네 번째(3번) 폰켓몬을 선택


        1. 조합을 탐색한다
        2. 조합 배열에서 서로 다른 숫자가 몇개인지 체크 한다
        3. 2의 값중 max 값을 리턴한다

         */
    }

    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                answer++;
            }

            if (list.size() == nums.length / 2) {
                break;
            }
        }

        return answer;

    }


}
