package com.kkh.codingtest.sort;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LV2CodingTest_Sort2_Solution {

    /*
    0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
    예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
    0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

    제한 사항
    numbers의 길이는 1 이상 100,000 이하입니다.
    numbers의 원소는 0 이상 1,000 이하입니다.
    정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
     */

    public static void main(String args[]) {
        LV2CodingTest_Sort2_Solution l = new LV2CodingTest_Sort2_Solution();

        System.out.println(l.solution(new int[]{6, 10, 2}));      //6210
        System.out.println(l.solution(new int[]{3, 30, 34, 5, 9}));      //9534330
        System.out.println(l.solution(new int[]{0, 0, 5, 0, 1}));      //
        System.out.println(l.solution(new int[]{0, 0, 0}));      //
        System.out.println(l.solution(new int[]{1, 2, 30, 3, 4, 5}));      //
        System.out.println(l.solution(new int[]{1000, 1, 1000, 1, 1000, 2, 1000, 2, 1000, 1000,}));      //
    }

    class NumberTextClass implements Comparable<NumberTextClass> {
        String value;

        public NumberTextClass(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(NumberTextClass o) {

            StringBuilder v1 = new StringBuilder(value).append(o.value);
            StringBuilder v2 = new StringBuilder(o.value).append(value);

            if (Integer.parseInt(v1.toString()) <= Integer.parseInt(v2.toString())) {
                return 1;
            } else {
                return -1;
            }

        }

        @Override
        public String toString() {
            return "NumberTextClass{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    public String solution(int[] numbers) {
        // 리스트가 아닌 배열로 하는게 빠르다
        String[] list = new String[numbers.length];
        for (int index = 0; index < numbers.length; index++) {
            list[index] = String.valueOf(numbers[index]);
        }
        Arrays.sort(list, (o1, o2) -> {
            /*
            if (Integer.parseInt(o1 + o2) <= Integer.parseInt(o2 + o1)) {
                return 1;
            } else {
                return -1;
            }
             */
            return ((o2 + o1).compareTo(o1 + o2));  // 직접비교보다 빠르다
        });
        String answer = "";
        if (list[0].equals("0")) {
            answer = "0";
        } else {
            for (String str : list) {
                answer += str;
            }
        }
        return answer;
    }

    public String solution_(int[] numbers) {

        /*
        1. 배열 정렬한다
        2. 정렬 우선순위
        34 30 3 -> 34 3 30
         */
        ArrayList<NumberTextClass> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(new NumberTextClass(String.valueOf(number)));
        }
        Collections.sort(list);
        StringBuilder answer = new StringBuilder();
        if (list.get(0).value.equals("0")) {
            answer.append("0");
        } else {
            for (NumberTextClass numberTextClass : list) {
                answer.append(numberTextClass.value);
            }
        }
        return answer.toString();
    }

}
