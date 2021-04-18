package com.kkh.algo.codingtest.dynamic;

import java.util.ArrayList;

public class LV3CodingTest_DP1_Solution {
    /*
    아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
    12 = 5 + 5 + (5 / 5) + (5 / 5)
    12 = 55 / 5 + 5 / 5
    12 = (55 + 5) / 5

    5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
    이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.

    제한사항
    N은 1 이상 9 이하입니다.
    number는 1 이상 32,000 이하입니다.
    수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
    최솟값이 8보다 크면 -1을 return 합니다.
     */
    public static void main(String args[]) {
        LV3CodingTest_DP1_Solution l = new LV3CodingTest_DP1_Solution();
        System.out.println(l.solution(5, 12));       //4
        System.out.println(l.solution(2, 11));       //3
        System.out.println(l.solution(5, 31168));       //-1
    }

    public int solution(int N, int number) {

        /*
        1. N은 최대 8이다
        2. N이 1번부터 8번 사용하여 만들 수 있는 모든 숫자를 만든다. 8개의 set을 만든다.
        3. 1~8 set 순회하면서 contain 체크한다

        5만 사용해야한다
        1회
        5
        2회
        5*5=25  5/5=1   5+5=10  5-5=0

        3회
        5*5*5=125   5/5/5=0.2   5+5+5=15    5-5-5=-5
        5*5/5=5
        5*5-5
        ...
        2회 + 1회
        5*5+5=30    5/5+5=6     5+5+5=15    5-5+5=5

        1회
        2회 = 1회 조합 * 1회 조합 경우의수
        3회 = 1회 조합 * 2회 조합 경우의수 + 2회 조합 * 1회 조합 경우의수
        4회 = 1회 조합 * 3회 조합 경우의수 + 3회 조합 * 1회 조합 경우의수 + 2회 조합 * 2회 조합 경우의수           // 순회하면서 n , 1-n과 연산한다
         */

        //5 55 555 5555 55555 ... 55555555
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        String text = "";
        for (int i = 1; i <= 8; i++) {
            text = text.concat(String.valueOf(N));
            int num = Integer.parseInt(text);
            ArrayList subList = new ArrayList();
            subList.add(num);
            list.add(subList);
        }
        int MAX = 8;
        for (int i = 1; i <= MAX; i++) {
            // 1,3 2,2 3,1 이런식으로 반복되어야 한다
            // ex)i:4
            // j:1,k:3, j:2,k:2, j:3,k:1
            ArrayList<Integer> subList = list.get(i - 1);
            for (int j = 1; j < i; j++) {
//                System.out.println("i : " + i + " , j : " + j + " , k : " + (i - j));
                int k = i - j;
                ArrayList<Integer> list1 = list.get(j - 1);
                ArrayList<Integer> list2 = list.get(k - 1);
                for (int i1 = 0; i1 < list1.size(); i1++) {
                    int num1 = list1.get(i1);
                    for (int j1 = 0; j1 < list2.size(); j1++) {
                        int num2 = list2.get(j1);
                        int value1 = num1 + num2;
                        if (value1 > 0 && !subList.contains(value1)) {
                            subList.add(value1);
                        }

                        int value2 = num1 - num2;
                        if (value2 > 0 && !subList.contains(value2)) {
                            subList.add(value2);
                        }

                        int value3 = num1 * num2;
                        if (value3 > 0 && !subList.contains(value3)) {
                            subList.add(value3);
                        }

                        if (num2 > 0) {
                            int value4 = num1 / num2;
                            if (value4 > 0 && !subList.contains(value4)) {
                                subList.add(value4);
                            }
                        }
                    }
                }
            }
        }
        int answer = -1;
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> subList = list.get(i);
            if (subList.contains(number)) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

}
