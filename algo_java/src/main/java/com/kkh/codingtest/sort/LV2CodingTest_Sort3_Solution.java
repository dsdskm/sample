package com.kkh.codingtest.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

public class LV2CodingTest_Sort3_Solution {
    /*

    H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
    어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
    어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

    5편중 3번 이상 인용된 논문이 3개, 아닌것이 2개 만족하면 H = 3
     */
    public static void main(String args[]) {
        LV2CodingTest_Sort3_Solution l = new LV2CodingTest_Sort3_Solution();
        System.out.println(l.solution(new int[]{3, 0, 6, 1, 5}));   //3
        System.out.println(l.solution(new int[]{3, 2, 6, 1, 5, 4, 9}));   //4
        System.out.println(l.solution(new int[]{100, 100, 50, 50}));
        System.out.println(l.solution(new int[]{1}));   //1
        System.out.println(l.solution(new int[]{9}));   //1
    }


    public int solution(int[] citations) {

        /*
        1. 평균 인용 횟수를 구한다
        2. 정렬한다
        3. 평균 인용 횟수보다 큰 인용 횟수만 반복적으로 계산한다
        1편 케이스 고려
         */
        Arrays.sort(citations);
        int value = 1;
        int count = 0;
        // value번 이상 인용된 횟수 count 개

        while (true) {
            count = 0;
            for (int i = 0; i < citations.length; i++) {
                if (value <= citations[i]) {
                    count++;
                }
            }

            if (count <= value) {
                break;
            }
            value++;
//            System.out.println("count : " + count + " , value : " + value + " , remain : " + String.valueOf(citations.length - count));
        }

        return count;
    }
}
