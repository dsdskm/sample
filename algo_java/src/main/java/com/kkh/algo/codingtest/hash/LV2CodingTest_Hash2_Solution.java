package com.kkh.algo.codingtest.hash;

import java.util.Arrays;

public class LV2CodingTest_Hash2_Solution {
    /*
    전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
    전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
    구조대 : 119
    박준영 : 97 674 223
    지영석 : 11 9552 4421
    전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
    어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
     */
    public static void main(String args[]) {

        String p1[];
        p1 = new String[]{"119", "9764223", "1195524421"};
        System.out.println(new LV2CodingTest_Hash2_Solution().solution(p1));
        p1 = new String[]{"123", "456", "789"};
        System.out.println(new LV2CodingTest_Hash2_Solution().solution(p1));
        p1 = new String[]{"12", "123", "1235", "567", "88"};
        System.out.println(new LV2CodingTest_Hash2_Solution().solution(p1));

    }

    public boolean solution(String[] phone_book) {
        /*
        1. 문자열 정렬
        1-1. 배열 길 1이면 return false
        2. 순회하면서 전후 값을 startsWidth로 비교
         */
        boolean answer = true;
        if (phone_book.length == 1) {
            return false;
        }

        Arrays.sort(phone_book);
        for (int i = 1; i < phone_book.length; i++) {
            String phone = phone_book[i];
            String prv = phone_book[i-1];
            if(prv.startsWith(phone) || phone.startsWith(prv)){
                answer = false;
                break;
            }
        }


        return answer;
    }
}
