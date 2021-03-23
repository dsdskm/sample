package com.kkh.codingtest.level1_test;

import java.util.ArrayList;
import java.util.Collections;

public class TwoSum {
    // https://programmers.co.kr/learn/courses/30/lessons/68644

    public static void main(String args[]) {

        /*
        정수 배열 numbers가 주어집니다.
        numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
         */

        TwoSum t = new TwoSum();
        System.out.println(t.solution(new int[]{2, 1, 3, 4, 1}));
        System.out.println(t.solution(new int[]{5, 0, 2, 7}));
    }

    public int[] solution(int[] numbers) {
        /*
        1. n개의 배열에서 r개를 뽑아 만들 수 있는 조합의 수를 구한다
        2. r개의 조합을 구할때마다 합을 list에 추가한다.(중복 체크한다)
        3. list를 array로 변환하여 정렬하여 리턴한다.
         */
        ArrayList<Integer> list = new ArrayList<>();

        boolean isVisited[] = new boolean[numbers.length];
        combination(numbers, isVisited, 0, numbers.length, 2, list);

        Collections.sort(list);
        int answer[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
            //System.out.println("answer : " + answer[i]);
        }

        return answer;
    }

    void combination(int[] arr, boolean[] visited, int start, int n, int r, ArrayList<Integer> list) {
        if (r == 0) {
            add(arr, visited, n, list);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, list);
            visited[i] = false;
        }
    }

    void add(int[] arr, boolean[] visited, int n, ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += arr[i];
            }
        }
        if (!list.contains(sum)) {
            list.add(sum);
        }
    }

}
