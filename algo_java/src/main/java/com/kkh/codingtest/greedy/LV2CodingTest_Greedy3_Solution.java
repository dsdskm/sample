package com.kkh.codingtest.greedy;

import java.util.*;

public class LV2CodingTest_Greedy3_Solution {
    /*
    어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
    예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
    문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
    number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
    제한 조건
    number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
    k는 1 이상 number의 자릿수 미만인 자연수입니다.
     */
    public static void main(String args[]) {
        LV2CodingTest_Greedy3_Solution l = new LV2CodingTest_Greedy3_Solution();
        System.out.println(l.solution("1924", 2));
//        System.out.println(l.solution("1231234", 3));
//        System.out.println(l.solution("4177252841", 4));
    }


    public String solution(String number, int k) {

        /*
        앞자리수 중 제일 클 수 있는 수를 찾아야한다.
        len - k 범위내에서 가장 큰수를 찾고
        그다음 자리수부터 찾아간다
         */
        int arr[] = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            arr[i] = Character.getNumericValue(number.charAt(i));
        }

        int max = 0;
        for (int i = 0; i < arr.length - k; i++) {
            if (max <= arr[i]) {
                max = arr[i];
            }
        }

        System.out.println("max : "+max);

        String ret = "";
        return ret;
    }
}
