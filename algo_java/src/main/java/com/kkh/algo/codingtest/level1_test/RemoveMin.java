package com.kkh.algo.codingtest.level1_test;

public class RemoveMin {
    // https://programmers.co.kr/learn/courses/30/lessons/12935

    /*
    정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

    제한 조건
    arr은 길이 1 이상인 배열입니다.
    인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
     */
    public static void main(String args[]) {
        RemoveMin r = new RemoveMin();
        r.solution(new int[]{4, 3, 2, 1});
        r.solution(new int[]{10});
    }

    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        int answer[] = new int[arr.length - 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min != arr[i]) {
                answer[index++] = arr[i];
            }
        }

        return answer;
    }
}
