package com.kkh.algo.codingtest.bruteforce;

import java.util.HashSet;
import java.util.Set;

public class LV2CodingTest_BF2_Solution {
    /*

    한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
    각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
    제한사항
    numbers는 길이 1 이상 7 이하인 문자열입니다.
    numbers는 0~9까지 숫자만으로 이루어져 있습니다.
    "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
     */
    public static void main(String args[]) {
        LV2CodingTest_BF2_Solution l = new LV2CodingTest_BF2_Solution();
//        System.out.println(l.solution("011"));       // 2
        System.out.println(l.solution("300"));       // 2
    }
    Set<Integer> set = new HashSet<>();
    Set<Integer> indexSet = new HashSet<>();

    public int solution(String numbers) {
        /*
        1. 문자열을 낱개로 분리하여 char 배열에 저장
        2. 낱개 문자를 모두 조합 -> 배열
        3. 조합 배열 순회하면서 소수 여부 체크 후 set에 추가
        -> 0,1는 소수가 아
         */
        char[] nums = new char[numbers.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numbers.charAt(i);
        }

        for (int i = 0; i < nums.length; i++) {
            indexSet.clear();
            indexSet.add(i);
            check(nums, String.valueOf(numbers.charAt(i)));
        }

        return set.size();
    }

    private void check(char[] nums, String from) {
        if (from.length() == nums.length) {
            return;
        }
        int value = Integer.parseInt(from);
        if (isPrime(value)) {
            set.add(value);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!indexSet.contains(i)) {
                String insert = from + nums[i];
                int insertValue = Integer.parseInt(insert);
                if (isPrime(insertValue)) {
                    set.add(insertValue);
                }

                indexSet.add(i);
                check(nums, insert);
                indexSet.remove(i);

            }
        }
    }

    private boolean isPrime(int num) {

        if (num == 0 || num == 1 ) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
